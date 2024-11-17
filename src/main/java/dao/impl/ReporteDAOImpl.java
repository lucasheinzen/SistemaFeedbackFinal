package dao.impl;

import conexion.DatabaseConnection;
import dao.ReporteDAO;
import modelo.Reporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz ReporteDAO para la gestión de reportes en la base de datos.
 */
public class ReporteDAOImpl implements ReporteDAO {

    @Override
    public void insertarReporte(Reporte reporte) {
        String sql = "INSERT INTO Reporte (categoria, numero_problemas, fecha_generacion, id_desarrollador) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, reporte.getCategoria());
            pstmt.setInt(2, reporte.getNumeroProblemas());
            pstmt.setString(3, reporte.getFechaGeneracion());
            pstmt.setInt(4, reporte.getIdDesarrollador()); // Asegurate de que este ID sea válido
            pstmt.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                reporte.setIdReporte(generatedKeys.getInt(1));
                System.out.println("Reporte insertado con éxito. ID generado: " + reporte.getIdReporte());
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar reporte: " + e.getMessage());
        }
    }

    @Override
    public Reporte obtenerReportePorId(int id) {
        String sql = "SELECT * FROM Reporte WHERE id_reporte = ?";
        Reporte reporte = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                reporte = new Reporte(
                        rs.getInt("id_reporte"),
                        rs.getString("categoria"),
                        rs.getInt("numero_problemas"),
                        rs.getString("fecha_generacion"),
                        rs.getInt("id_desarrollador")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporte;
    }

    @Override
    public List<Reporte> obtenerTodosLosReportes() {
        List<Reporte> reportes = new ArrayList<>();
        String sql = "SELECT * FROM Reporte";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                reportes.add(new Reporte(
                        rs.getInt("id_reporte"),
                        rs.getString("categoria"),
                        rs.getInt("numero_problemas"),
                        rs.getString("fecha_generacion"),
                        rs.getInt("id_desarrollador")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }

    @Override
    public void actualizarReporte(Reporte reporte) {
        String sql = "UPDATE Reporte SET categoria = ?, numero_problemas = ?, fecha_generacion = ? WHERE id_reporte = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, reporte.getCategoria());
            pstmt.setInt(2, reporte.getNumeroProblemas());
            pstmt.setString(3, reporte.getFechaGeneracion());
            pstmt.setInt(4, reporte.getIdReporte());
            pstmt.executeUpdate();
            System.out.println("Reporte actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarReporte(int id) {
        String sql = "DELETE FROM Reporte WHERE id_reporte = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Reporte eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

