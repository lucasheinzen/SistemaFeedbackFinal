package dao.impl;

import conexion.DatabaseConnection;
import dao.JugadorDAO;
import modelo.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorDAOImpl implements JugadorDAO {

    @Override
    public void insertarJugador(Jugador jugador) {
        String sql = "INSERT INTO Jugador (nombre_usuario, correo, contraseña) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, jugador.getNombreUsuario());
            pstmt.setString(2, jugador.getCorreo());
            pstmt.setString(3, jugador.getContraseña());
            pstmt.executeUpdate();
            System.out.println("Jugador insertado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jugador obtenerJugadorPorId(int id) {
        String sql = "SELECT * FROM Jugador WHERE id_jugador = ?";
        Jugador jugador = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                jugador = new Jugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre_usuario"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }

    @Override
    public void actualizarJugador(Jugador jugador) {
        String sql = "UPDATE Jugador SET correo = ?, contraseña = ? WHERE id_jugador = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, jugador.getCorreo());
            pstmt.setString(2, jugador.getContraseña());
            pstmt.setInt(3, jugador.getIdJugador());
            pstmt.executeUpdate();
            System.out.println("Jugador actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarJugador(int id) {
        String sql = "DELETE FROM Jugador WHERE id_jugador = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Jugador eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
