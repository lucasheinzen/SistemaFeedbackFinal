package test;

import dao.impl.DesarrolladorDAOImpl;
import dao.impl.FeedbackDAOImpl;
import dao.impl.JugadorDAOImpl;
import dao.impl.ReporteDAOImpl;
import modelo.Desarrollador;
import modelo.Feedback;
import modelo.Jugador;
import modelo.Reporte;

public class TestSistemaFeedback {
    public static void main(String[] args) {
        // DAOs
        JugadorDAOImpl jugadorDAO = new JugadorDAOImpl();
        DesarrolladorDAOImpl desarrolladorDAO = new DesarrolladorDAOImpl();
        FeedbackDAOImpl feedbackDAO = new FeedbackDAOImpl();
        ReporteDAOImpl reporteDAO = new ReporteDAOImpl();

        // 1. Insertar Jugador
        Jugador nuevoJugador = new Jugador(0, "usuario4", "usuario4@gmail.com", "securePass4");
        jugadorDAO.insertarJugador(nuevoJugador);

        // 2. Insertar Desarrollador
        Desarrollador nuevoDesarrollador = new Desarrollador(0, "dev4", "dev4@gmail.com", "devPass4");
        desarrolladorDAO.insertarDesarrollador(nuevoDesarrollador);

        // 3. Insertar Feedback
        Feedback nuevoFeedback = new Feedback(0, "Gráficos", "Problema de texturas", "2024-11-17", 1);
        feedbackDAO.insertarFeedback(nuevoFeedback);

        // 4. Insertar Reporte
        Reporte nuevoReporte = new Reporte(0, "Jugabilidad", 10, "2024-11-17", 1);
        reporteDAO.insertarReporte(nuevoReporte);

        // 5. Obtener y Mostrar Información
        System.out.println("Jugador obtenido: " + jugadorDAO.obtenerJugadorPorId(1).getNombreUsuario());
        System.out.println("Desarrollador obtenido: " + desarrolladorDAO.obtenerDesarrolladorPorId(1).getNombreUsuario());
        System.out.println("Feedback obtenido: " + feedbackDAO.obtenerFeedbackPorId(1).getDescripcion());
        System.out.println("Reporte obtenido: " + reporteDAO.obtenerReportePorId(1).getCategoria());

        // 6. Actualizar Información
        nuevoFeedback.setDescripcion("Error gráfico corregido");
        feedbackDAO.actualizarFeedback(nuevoFeedback);

        // 7. Eliminar Información
        reporteDAO.eliminarReporte(1);
        feedbackDAO.eliminarFeedback(1);
        desarrolladorDAO.eliminarDesarrollador(1);
        jugadorDAO.eliminarJugador(1);
    }
}
