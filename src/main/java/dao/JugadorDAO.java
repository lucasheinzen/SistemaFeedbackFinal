package dao;

import modelo.Jugador;

public interface JugadorDAO {
    void insertarJugador(Jugador jugador);
    Jugador obtenerJugadorPorId(int id);
    void actualizarJugador(Jugador jugador);
    void eliminarJugador(int id);
}
