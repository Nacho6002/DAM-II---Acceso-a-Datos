package gestionamigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_BD {
    
    // credenciales de docker
    private static final String URL = "jdbc:mysql://localhost:3306/mis_amigos";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // meto el driver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("¡Conexión a la base de datos OK!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }
}