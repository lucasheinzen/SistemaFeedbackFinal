package dao.impl;

import conexion.DatabaseConnection;
import dao.FeedbackDAO;
import modelo.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz FeedbackDAO para la gestión de feedbacks en la base de datos.
 */
public class FeedbackDAOImpl implements FeedbackDAO {

    @Override
    public void insertarFeedback(Feedback feedback) {
        String sql = "INSERT INTO Feedback (tipo_feedback, descripcion, fecha_envio, id_jugador) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, feedback.getTipoFeedback());
            pstmt.setString(2, feedback.getDescripcion());
            pstmt.setString(3, feedback.getFechaEnvio());
            pstmt.setInt(4, feedback.getIdJugador()); // Asegurate de que este ID sea válido
            pstmt.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                feedback.setIdFeedback(generatedKeys.getInt(1));
                System.out.println("Feedback insertado con éxito. ID generado: " + feedback.getIdFeedback());
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar feedback: " + e.getMessage());
        }
    }

    @Override
    public Feedback obtenerFeedbackPorId(int id) {
        String sql = "SELECT * FROM Feedback WHERE id_feedback = ?";
        Feedback feedback = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                feedback = new Feedback(
                        rs.getInt("id_feedback"),
                        rs.getString("tipo_feedback"),
                        rs.getString("descripcion"),
                        rs.getString("fecha_envio"),
                        rs.getInt("id_jugador")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    @Override
    public List<Feedback> obtenerTodosLosFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM Feedback";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                feedbacks.add(new Feedback(
                        rs.getInt("id_feedback"),
                        rs.getString("tipo_feedback"),
                        rs.getString("descripcion"),
                        rs.getString("fecha_envio"),
                        rs.getInt("id_jugador")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    @Override
    public void actualizarFeedback(Feedback feedback) {
        String sql = "UPDATE Feedback SET tipo_feedback = ?, descripcion = ?, fecha_envio = ? WHERE id_feedback = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, feedback.getTipoFeedback());
            pstmt.setString(2, feedback.getDescripcion());
            pstmt.setString(3, feedback.getFechaEnvio());
            pstmt.setInt(4, feedback.getIdFeedback());
            pstmt.executeUpdate();
            System.out.println("Feedback actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarFeedback(int id) {
        String sql = "DELETE FROM Feedback WHERE id_feedback = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Feedback eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
