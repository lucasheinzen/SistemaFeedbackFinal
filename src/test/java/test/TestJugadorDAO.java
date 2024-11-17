package test;

import dao.impl.JugadorDAOImpl;
import modelo.Jugador;

/**
 * Clase de prueba para la implementación de JugadorDAO.
 * Proporciona métodos para probar las operaciones CRUD sobre la tabla Jugador.
 */

public class TestJugadorDAO {
    public static void main(String[] args) {
        JugadorDAOImpl jugadorDAO = new JugadorDAOImpl();

        // Insertar un nuevo jugador
        Jugador nuevoJugador = new Jugador(0, "usuario_test", "test@gmail.com", "password123");
        jugadorDAO.insertarJugador(nuevoJugador);

        // Obtener el ID generado
        int idGenerado = nuevoJugador.getIdJugador(); // El ID generado se asigna aquí
        System.out.println("Buscando jugador con ID: " + idGenerado);

        // Obtener el jugador por ID
        Jugador jugador = jugadorDAO.obtenerJugadorPorId(idGenerado);
        if (jugador != null) {
            System.out.println("Jugador obtenido: " + jugador.getNombreUsuario());
        } else {
            System.out.println("El jugador con el ID proporcionado no existe.");
        }
    }
}


