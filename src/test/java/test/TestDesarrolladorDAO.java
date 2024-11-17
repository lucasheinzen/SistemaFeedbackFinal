package test;

import dao.impl.DesarrolladorDAOImpl;
import modelo.Desarrollador;

public class TestDesarrolladorDAO {
    public static void main(String[] args) {
        DesarrolladorDAOImpl desarrolladorDAO = new DesarrolladorDAOImpl();

        // Insertar desarrollador
        Desarrollador nuevoDesarrollador = new Desarrollador(0, "dev_test", "dev_test@gmail.com", "password_test");
        desarrolladorDAO.insertarDesarrollador(nuevoDesarrollador);

        // Obtener el ID generado
        int idGenerado = nuevoDesarrollador.getIdDesarrollador();
        System.out.println("Buscando desarrollador con ID: " + idGenerado);

        // Obtener desarrollador por ID
        Desarrollador desarrollador = desarrolladorDAO.obtenerDesarrolladorPorId(idGenerado);
        if (desarrollador != null) {
            System.out.println("Desarrollador obtenido: " + desarrollador.getNombreUsuario());
        } else {
            System.out.println("El desarrollador con el ID proporcionado no existe.");
        }
    }
}



