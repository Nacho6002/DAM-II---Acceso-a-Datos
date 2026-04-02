package gestionamigos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PandillaDAO {

    // Método para obtener todas las pandillas
    public List<Pandilla> obtenerTodas() {
        List<Pandilla> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            conexion = Conexion_BD.obtenerConexion();
            String sql = "SELECT * FROM pandilla";
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_pandilla");
                String nombre = rs.getString("nombre");
                String lugar = rs.getString("lugar_vacaciones");
                
                Pandilla p = new Pandilla(id, nombre, lugar);
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las pandillas.");
            e.printStackTrace();
        } finally {
            // Se cierra todo 
            try {
                if (rs != null) rs.close();
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}