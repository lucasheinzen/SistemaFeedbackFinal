package test;

import dao.impl.JugadorDAOImpl;
import modelo.Jugador;

public class TestJugadorDAO {
    public static void main(String[] args) {
        JugadorDAOImpl jugadorDAO = new JugadorDAOImpl();

        // Insertar jugador
        jugadorDAO.insertarJugador(new Jugador(0, "usuarioTest", "correo@test.com", "pass123"));

        // Obtener jugador
        Jugador jugador = jugadorDAO.obtenerJugadorPorId(1);
        System.out.println("Jugador obtenido: " + jugador.getNombreUsuario());
    }
}
