package dao;

import modelo.Desarrollador;

public interface DesarrolladorDAO {
    void insertarDesarrollador(Desarrollador desarrollador);
    Desarrollador obtenerDesarrolladorPorId(int id);
    void actualizarDesarrollador(Desarrollador desarrollador);
    void eliminarDesarrollador(int id);
}
