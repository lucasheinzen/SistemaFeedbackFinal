package modelo;

public class Reporte {
    private int idReporte;
    private String categoria;
    private int numeroProblemas;
    private int idDesarrollador;

    public Reporte(int idReporte, String categoria, int numeroProblemas, int idDesarrollador) {
        this.idReporte = idReporte;
        this.categoria = categoria;
        this.numeroProblemas = numeroProblemas;
        this.idDesarrollador = idDesarrollador;
    }

    // Getters y Setters
}
