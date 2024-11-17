package modelo;

public class Desarrollador {
    private int idDesarrollador;
    private String nombreUsuario;
    private String correo;
    private String contraseña;

    public Desarrollador(int idDesarrollador, String nombreUsuario, String correo, String contraseña) {
        this.idDesarrollador = idDesarrollador;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public int getIdDesarrollador() { return idDesarrollador; }
    public void setIdDesarrollador(int idDesarrollador) { this.idDesarrollador = idDesarrollador; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
