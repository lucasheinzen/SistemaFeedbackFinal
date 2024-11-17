package modelo;

/**
 * Clase que representa un feedback proporcionado por un jugador.
 * Contiene detalles como la descripción, el tipo de feedback y la fecha.
 */
public class Feedback {
    private int idFeedback;
    private String tipoFeedback;
    private String descripcion;
    private String fechaEnvio;
    private int idJugador;

    /**
     * Constructor de la clase Feedback.
     *
     * @param idFeedback   Identificador único del feedback.
     * @param tipoFeedback Tipo de feedback (Errores, Jugabilidad, Gráficos, etc.).
     * @param descripcion  Descripción detallada del feedback.
     * @param fechaEnvio   Fecha en la que se envió el feedback.
     * @param idJugador    ID del jugador que envió el feedback.
     */

    public Feedback(int idFeedback, String tipoFeedback, String descripcion, String fechaEnvio, int idJugador) {
        this.idFeedback = idFeedback;
        this.tipoFeedback = tipoFeedback;
        this.descripcion = descripcion;
        this.fechaEnvio = fechaEnvio;
        this.idJugador = idJugador;
    }

    // Getters y Setters
    public int getIdFeedback() { return idFeedback; }
    public void setIdFeedback(int idFeedback) { this.idFeedback = idFeedback; }

    public String getTipoFeedback() { return tipoFeedback; }
    public void setTipoFeedback(String tipoFeedback) { this.tipoFeedback = tipoFeedback; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(String fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public int getIdJugador() { return idJugador; }
    public void setIdJugador(int idJugador) { this.idJugador = idJugador; }
}
