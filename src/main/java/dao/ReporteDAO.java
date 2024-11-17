package dao;

import modelo.Reporte;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Reporte.
 */
public interface ReporteDAO {
    void insertarReporte(Reporte reporte);
    Reporte obtenerReportePorId(int id);
    List<Reporte> obtenerTodosLosReportes();
    void actualizarReporte(Reporte reporte);
    void eliminarReporte(int id);
}
