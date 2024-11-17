package test;

import dao.impl.FeedbackDAOImpl;
import modelo.Feedback;

public class TestFeedbackDAO {
    public static void main(String[] args) {
        FeedbackDAOImpl feedbackDAO = new FeedbackDAOImpl();

        // Insertar feedback
        int idJugadorExistente = 1; // Asegurate de que este ID exista en la tabla Jugador
        Feedback nuevoFeedback = new Feedback(0, "Jugabilidad", "Problemas con los controles", "2024-11-17", idJugadorExistente);
        feedbackDAO.insertarFeedback(nuevoFeedback);

        // Obtener feedback por ID
        Feedback feedback = feedbackDAO.obtenerFeedbackPorId(1); // Cambia el ID según corresponda
        if (feedback != null) {
            System.out.println("Feedback obtenido: " + feedback.getDescripcion());
        } else {
            System.out.println("El feedback con el ID proporcionado no existe.");
        }
    }
}


