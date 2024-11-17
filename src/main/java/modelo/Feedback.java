package modelo;

public class Feedback {
    private int idFeedback;
    private String tipoFeedback;
    private String descripcion;
    private int idJugador;

    public Feedback(int idFeedback, String tipoFeedback, String descripcion, int idJugador) {
        this.idFeedback = idFeedback;
        this.tipoFeedback = tipoFeedback;
        this.descripcion = descripcion;
        this.idJugador = idJugador;
    }

    // Getters y Setters
}
