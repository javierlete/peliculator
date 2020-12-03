package com.ipartek.formacion.uf2213_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/peliculas_bdd";
        String user = "debian-sys-maint";
        String pass = "o8lAkaNtX91xMUcV";
        
        String sqlSelect = "SELECT * FROM peliculas";
        String sqlSelectPorId = "SELECT * FROM peliculas WHERE id = 1";
        String sqlInsert = "INSERT INTO peliculas (titulo, genero, fecha_estreno) VALUES ('Spiderman', 'Superheroes', '2000-6-7')";
        String sqlUpdate = "UPDATE peliculas SET titulo = 'Spiderman2', genero = 'Otra más de supers' WHERE id = 3";
        String sqlDelete = "DELETE FROM peliculas WHERE id = 1";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sqlSelect);
        
        while(rs.next()) {
        	System.out.println(rs.getLong("id"));
        	System.out.println(rs.getString("titulo"));
        	System.out.println(rs.getString("genero"));
        	System.out.println(rs.getDate("fecha_estreno"));
        }
        
        System.out.println("FIN");
        
        int numeroRegistrosModificados = st.executeUpdate(sqlInsert);
        
        System.out.println(numeroRegistrosModificados);
    }
}
