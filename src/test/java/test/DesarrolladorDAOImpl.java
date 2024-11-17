package test;

import dao.impl.DesarrolladorDAOImpl;
import modelo.Desarrollador;

public class TestDesarrolladorDAO {
    public static void main(String[] args) {
        DesarrolladorDAOImpl desarrolladorDAO = new DesarrolladorDAOImpl();

        // Insertar desarrollador
        Desarrollador nuevoDesarrollador = new Desarrollador(0, "devTest", "dev@test.com", "devPass123");
        desarrolladorDAO.insertarDesarrollador(nuevoDesarrollador);

        // Obtener desarrollador
        Desarrollador desarrollador = desarrolladorDAO.obtenerDesarrolladorPorId(1);
        System.out.println("Desarrollador obtenido: " + desarrollador.getNombreUsuario());

        // Actualizar desarrollador
        desarrollador.setCorreo("correoActualizado@dev.com");
        desarrollador.setContraseña("passActualizado");
        desarrolladorDAO.actualizarDesarrollador(desarrollador);

        // Eliminar desarrollador
        desarrolladorDAO.eliminarDesarrollador(1);
    }
}
