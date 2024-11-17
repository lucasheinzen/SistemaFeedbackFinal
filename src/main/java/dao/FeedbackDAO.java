package dao;

import modelo.Feedback;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Feedback.
 */
public interface FeedbackDAO {
    void insertarFeedback(Feedback feedback);
    Feedback obtenerFeedbackPorId(int id);
    List<Feedback> obtenerTodosLosFeedbacks();
    void actualizarFeedback(Feedback feedback);
    void eliminarFeedback(int id);
}
