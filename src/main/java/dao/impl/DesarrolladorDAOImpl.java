package dao.impl;

import conexion.DatabaseConnection;
import dao.DesarrolladorDAO;
import modelo.Desarrollador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DesarrolladorDAOImpl implements DesarrolladorDAO {

    @Override
    public void insertarDesarrollador(Desarrollador desarrollador) {
        String sql = "INSERT INTO Desarrollador (nombre_usuario, correo, contraseña) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, desarrollador.getNombreUsuario());
            pstmt.setString(2, desarrollador.getCorreo());
            pstmt.setString(3, desarrollador.getContraseña());
            pstmt.executeUpdate();
            System.out.println("Desarrollador insertado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Desarrollador obtenerDesarrolladorPorId(int id) {
        String sql = "SELECT * FROM Desarrollador WHERE id_desarrollador = ?";
        Desarrollador desarrollador = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                desarrollador = new Desarrollador(
                        rs.getInt("id_desarrollador"),
                        rs.getString("nombre_usuario"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return desarrollador;
    }

    @Override
    public void actualizarDesarrollador(Desarrollador desarrollador) {
        String sql = "UPDATE Desarrollador SET correo = ?, contraseña = ? WHERE id_desarrollador = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, desarrollador.getCorreo());
            pstmt.setString(2, desarrollador.getContraseña());
            pstmt.setInt(3, desarrollador.getIdDesarrollador());
            pstmt.executeUpdate();
            System.out.println("Desarrollador actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarDesarrollador(int id) {
        String sql = "DELETE FROM Desarrollador WHERE id_desarrollador = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Desarrollador eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
