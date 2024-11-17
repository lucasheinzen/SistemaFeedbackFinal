package modelo;

/**
 * Clase que representa un Reporte en el sistema.
 */
public class Reporte {
    private int idReporte;
    private String categoria;
    private int numeroProblemas;
    private String fechaGeneracion;
    private int idDesarrollador;

    // Constructor
    public Reporte(int idReporte, String categoria, int numeroProblemas, String fechaGeneracion, int idDesarrollador) {
        this.idReporte = idReporte;
        this.categoria = categoria;
        this.numeroProblemas = numeroProblemas;
        this.fechaGeneracion = fechaGeneracion;
        this.idDesarrollador = idDesarrollador;
    }

    // Getters y Setters
    public int getIdReporte() { return idReporte; }
    public void setIdReporte(int idReporte) { this.idReporte = idReporte; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getNumeroProblemas() { return numeroProblemas; }
    public void setNumeroProblemas(int numeroProblemas) { this.numeroProblemas = numeroProblemas; }

    public String getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(String fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public int getIdDesarrollador() { return idDesarrollador; }
    public void setIdDesarrollador(int idDesarrollador) { this.idDesarrollador = idDesarrollador; }
}

