package gestionamigos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmigoDAO {

    // metodo para agregar
    public void insertarAmigo(Amigo amigo) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            conexion = Conexion_BD.obtenerConexion();
            String sql = "INSERT INTO amigo (nombre, direccion, telefono, aficiones, id_pandilla) VALUES (?, ?, ?, ?, ?)";
            sentencia = conexion.prepareStatement(sql);
            
            sentencia.setString(1, amigo.getNombre());
            sentencia.setString(2, amigo.getDireccion());
            sentencia.setString(3, amigo.getTelefono());
            sentencia.setString(4, amigo.getAficiones());
            sentencia.setInt(5, amigo.getIdPandilla());
            
            int filas = sentencia.executeUpdate();
            System.out.println("Amigos insertados: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // metodo para listar
    public List<Amigo> obtenerTodos() {
        List<Amigo> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = Conexion_BD.obtenerConexion();
            String sql = "SELECT * FROM amigo";
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                Amigo a = new Amigo(
                    rs.getInt("id_amigo"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("aficiones"),
                    rs.getInt("id_pandilla")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    // metodo para modificar
    public void modificarAmigo(Amigo amigo) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            conexion = Conexion_BD.obtenerConexion();
            String sql = "UPDATE amigo SET nombre=?, direccion=?, telefono=?, aficiones=?, id_pandilla=? WHERE id_amigo=?";
            sentencia = conexion.prepareStatement(sql);
            
            sentencia.setString(1, amigo.getNombre());
            sentencia.setString(2, amigo.getDireccion());
            sentencia.setString(3, amigo.getTelefono());
            sentencia.setString(4, amigo.getAficiones());
            sentencia.setInt(5, amigo.getIdPandilla());
            sentencia.setInt(6, amigo.getIdAmigo());
            
            int filas = sentencia.executeUpdate();
            System.out.println("Amigos modificados: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // metodo para buscar 
    public List<Amigo> buscarAmigos(String criterio, String valor) {
        List<Amigo> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = Conexion_BD.obtenerConexion();
            
            String sql;
            if (criterio.equals("nombre")) {
                sql = "SELECT * FROM amigo WHERE nombre LIKE ?";
            } else {
                sql = "SELECT * FROM amigo WHERE telefono LIKE ?";
            }
            
            sentencia = conexion.prepareStatement(sql);
            
            sentencia.setString(1, "%" + valor + "%");
            
            rs = sentencia.executeQuery();

            while (rs.next()) {
                Amigo a = new Amigo(
                    rs.getInt("id_amigo"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("aficiones"),
                    rs.getInt("id_pandilla")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    // metodo para buscar con filtro de pandilla
    public List<Amigo> buscarAmigosAvanzado(String criterio, String valor, int idPandilla) {
        List<Amigo> lista = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = Conexion_BD.obtenerConexion();
            
            String sql;
            if (criterio.equals("nombre")) {
                if (idPandilla > 0) {
                    sql = "SELECT * FROM amigo WHERE nombre LIKE ? AND id_pandilla = ?";
                } else {
                    sql = "SELECT * FROM amigo WHERE nombre LIKE ?";
                }
            } else {
                if (idPandilla > 0) {
                    sql = "SELECT * FROM amigo WHERE telefono LIKE ? AND id_pandilla = ?";
                } else {
                    sql = "SELECT * FROM amigo WHERE telefono LIKE ?";
                }
            }
            
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, "%" + valor + "%");
            
            if (idPandilla > 0) {
                sentencia.setInt(2, idPandilla);
            }
            
            rs = sentencia.executeQuery();

            while (rs.next()) {
                Amigo a = new Amigo(
                    rs.getInt("id_amigo"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("aficiones"),
                    rs.getInt("id_pandilla")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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