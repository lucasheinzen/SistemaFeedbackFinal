package test;

import dao.impl.ReporteDAOImpl;
import modelo.Reporte;

public class TestReporteDAO {
    public static void main(String[] args) {
        ReporteDAOImpl reporteDAO = new ReporteDAOImpl();

        // Usar un ID de desarrollador válido
        int idDesarrolladorExistente = 1; // Este ID debe existir en la tabla Desarrollador
        Reporte nuevoReporte = new Reporte(0, "Jugabilidad", 5, "2024-11-17", idDesarrolladorExistente);
        reporteDAO.insertarReporte(nuevoReporte);

        // Obtener el ID generado
        int idGenerado = nuevoReporte.getIdReporte();
        System.out.println("Buscando reporte con ID: " + idGenerado);

        // Obtener el reporte por ID
        Reporte reporte = reporteDAO.obtenerReportePorId(idGenerado);
        if (reporte != null) {
            System.out.println("Reporte obtenido: " + reporte.getCategoria());
        } else {
            System.out.println("El reporte con el ID proporcionado no existe.");
        }
    }
}

