package modelo;
/**
 * Clase que representa a un jugador.
 * Contiene información sobre el jugador y métodos para acceder a sus datos.
 */

public class Jugador {
    private int idJugador;
    private String nombreUsuario;
    private String correo;
    private String contraseña;

    public Jugador(int idJugador, String nombreUsuario, String correo, String contraseña) {
        this.idJugador = idJugador;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public int getIdJugador() { return idJugador; }
    public void setIdJugador(int idJugador) { this.idJugador = idJugador; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
