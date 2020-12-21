package com.ipartek.formacion.uf2218.crud.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public class PeliculasDaoMySql implements Dao<Pelicula> {

	private static final Logger LOGGER = Logger.getLogger(PeliculasDaoMySql.class.getName());
	
	// SINGLETON
	private PeliculasDaoMySql() {
	}

	private static final PeliculasDaoMySql INSTANCIA = new PeliculasDaoMySql();

	public static PeliculasDaoMySql getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	// characterEncoding=UTF-8 cambia la codificación de los PreparedStatement de
	// Windows-1252 a UTF-8
	private static final String URL = "jdbc:mysql://localhost:3306/peliculas_bdd?characterEncoding=UTF-8";
	private static final String USER = "debian-sys-maint";
	private static final String PASS = "o8lAkaNtX91xMUcV";

	private static final String SQL_SELECT = "SELECT * FROM peliculas p JOIN generos g ON p.id_genero = g.id";
	private static final String SQL_SELECT_ID = "SELECT * FROM peliculas p JOIN generos g ON p.id_genero = g.id WHERE p.id = ?";
	private static final String SQL_INSERT = "INSERT INTO peliculas (titulo, id_genero, fecha_estreno) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE peliculas SET titulo = ?, id_genero = ?, fecha_estreno = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM peliculas WHERE id = ?";

	// EJEMPLO DE INYECCIÓN DE SQL
	// fecha_estreno = "2000-1-1'); DROP TABLE peliculas;--
	// "INSERT INTO peliculas (titulo, genero, fecha_estreno) VALUES ('" + titulo +
	// "', '" + genero + "', '" + fecha_estreno + "');"
	// "INSERT INTO peliculas (titulo, genero, fecha_estreno) VALUES ('asdf',
	// 'asdf', '2000-1-1'); DROP TABLE peliculas; --');"

	static {
		try {
			// Registramos el driver de MySQL de forma EXPLÍCITA ya que en las aplicaciones
			// web lo necesitan todavía
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido cargar el driver de MySQL", e);
		}
	}

	@Override
	public Iterable<Pelicula> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT);) {
			ArrayList<Pelicula> peliculas = new ArrayList<>();

			Pelicula pelicula;
			Genero genero;

			// Para convertir las filas de una tabla de la base de datos en objetos de una
			// colección
			while (rs.next()) {
				genero = new Genero(rs.getLong("g.id"), rs.getString("g.nombre"), rs.getString("g.descripcion"));
				
				pelicula = new Pelicula(rs.getLong("p.id"), rs.getString("p.titulo"), genero,
						null, rs.getDate("p.fecha_estreno").toLocalDate());

				peliculas.add(pelicula);
			}

			return peliculas;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema al obtener todos los registros de película", e);
		}

	}

	@Override
	public Pelicula obtenerPorId(Long id) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				Pelicula pelicula = null;

				Genero genero = null;
				
				if (rs.next()) {
					genero = new Genero(rs.getLong("g.id"), rs.getString("g.nombre"), rs.getString("g.descripcion"));
					
					pelicula = new Pelicula(rs.getLong("p.id"), rs.getString("p.titulo"), genero,
							null, rs.getDate("p.fecha_estreno").toLocalDate());
				}

				return pelicula;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema al obtener la película cuyo id es " + id, e);
		}
	}

	@Override
	public void insertar(Pelicula pelicula) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);) {

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
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

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
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

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
