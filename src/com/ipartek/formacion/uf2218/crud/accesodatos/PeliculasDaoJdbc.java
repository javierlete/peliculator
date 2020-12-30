package com.ipartek.formacion.uf2218.crud.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

import org.apache.commons.dbcp2.BasicDataSource;

public class PeliculasDaoJdbc implements Dao<Pelicula> {

	private static final Logger LOGGER = Logger.getLogger(PeliculasDaoJdbc.class.getName());

	private BasicDataSource dataSource;

	// SINGLETON
	private PeliculasDaoJdbc() {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        dataSource = new BasicDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		// try {
		// 	InitialContext initCtx = new InitialContext();
		// 	Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 	dataSource = (DataSource) envCtx.lookup("jdbc/peliculas");
		// } catch (NamingException e) {
		// 	throw new AccesoDatosException("No se ha encontrado el pool de conexiones", e);
		// }
	}

	private static final PeliculasDaoJdbc INSTANCIA = new PeliculasDaoJdbc();

	public static PeliculasDaoJdbc getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	private static final String SQL_SELECT = "SELECT g.id gid, g.nombre gnombre, g.descripcion gdescripcion, p.id pid, p.titulo ptitulo, p.fecha_estreno pfecha_estreno FROM peliculas_bdd.peliculas p JOIN peliculas_bdd.generos g ON p.id_genero = g.id";
	private static final String SQL_SELECT_ID = "SELECT g.id gid, g.nombre gnombre, g.descripcion gdescripcion, p.id pid, p.titulo ptitulo, p.fecha_estreno pfecha_estreno FROM peliculas_bdd.peliculas p JOIN peliculas_bdd.generos g ON p.id_genero = g.id WHERE p.id = ?";
	private static final String SQL_INSERT = "INSERT INTO peliculas_bdd.peliculas (titulo, id_genero, fecha_estreno) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE peliculas_bdd.peliculas SET titulo = ?, id_genero = ?, fecha_estreno = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM peliculas_bdd.peliculas WHERE id = ?";

	// EJEMPLO DE INYECCIÓN DE SQL
	// fecha_estreno = "2000-1-1'); DROP TABLE peliculas;--
	// "INSERT INTO peliculas (titulo, genero, fecha_estreno) VALUES ('" + titulo +
	// "', '" + genero + "', '" + fecha_estreno + "');"
	// "INSERT INTO peliculas (titulo, genero, fecha_estreno) VALUES ('asdf',
	// 'asdf', '2000-1-1'); DROP TABLE peliculas; --');"

	@Override
	public Iterable<Pelicula> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT);) {
			ArrayList<Pelicula> peliculas = new ArrayList<>();

			Pelicula pelicula;
			Genero genero;

			// Para convertir las filas de una tabla de la base de datos en objetos de una
			// colección
			while (rs.next()) {
				genero = new Genero(rs.getLong("gid"), rs.getString("gnombre"), rs.getString("gdescripcion"));

				pelicula = new Pelicula(rs.getLong("pid"), rs.getString("ptitulo"), genero, null,
						rs.getDate("pfecha_estreno").toLocalDate());

				peliculas.add(pelicula);
			}

			return peliculas;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema al obtener todos los registros de película", e);
		}

	}

	@Override
	public Pelicula obtenerPorId(Long id) {

		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				Pelicula pelicula = null;

				Genero genero = null;

				if (rs.next()) {
					genero = new Genero(rs.getLong("gid"), rs.getString("gnombre"), rs.getString("gdescripcion"));

					pelicula = new Pelicula(rs.getLong("pid"), rs.getString("ptitulo"), genero, null,
							rs.getDate("pfecha_estreno").toLocalDate());
				}

				return pelicula;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema al obtener la película cuyo id es " + id, e);
		}
	}

	@Override
	public void insertar(Pelicula pelicula) {
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(SQL_INSERT);) {

			ps.setString(1, pelicula.getTitulo());
			ps.setLong(2, pelicula.getGenero().getId());
			ps.setObject(3, pelicula.getFechaEstreno());

			int numeroRegistrosInsertados = ps.executeUpdate();

			if (numeroRegistrosInsertados == 0) {
				throw new AccesoDatosException("No se ha conseguido insertar el registro");
			} else if (numeroRegistrosInsertados > 1) {
				throw new AccesoDatosException("SE HA INSERTADO MÁS DE UN REGISTRO");
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema al insertar la película", e);
		}
	}

	@Override
	public void modificar(Pelicula pelicula) {
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pelicula.getTitulo());
			ps.setLong(2, pelicula.getGenero().getId());
			ps.setObject(3, pelicula.getFechaEstreno());
			ps.setLong(4, pelicula.getId());

			int numeroRegistrosModificados = ps.executeUpdate();

			if (numeroRegistrosModificados == 0) {
				throw new AccesoDatosException("No se ha encontrado el registro a modificar");
			} else if (numeroRegistrosModificados > 1) {
				throw new AccesoDatosException("SE HA MODIFICADO MÁS DE UN REGISTRO");
			}

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Ha habido un problema al modificar la película", e);
			throw new AccesoDatosException("Ha habido un problema al modificar la película", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id);

			int numeroRegistrosBorrados = ps.executeUpdate();

			if (numeroRegistrosBorrados == 0) {
				throw new AccesoDatosException("Se ha intentado borrar un id inexistente");
			} else if (numeroRegistrosBorrados > 1) {
				throw new AccesoDatosException("SE HA BORRADO MÁS DE UN REGISTRO");
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema al obtener la película cuyo id es " + id, e);
		}
	}

}
