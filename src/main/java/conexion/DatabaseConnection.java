package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que representa la conexión a la base de datos.
 * Proporciona un método estático para obtener una conexión JDBC.
 */

public class DatabaseConnection {
    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return Connection objeto que representa la conexión JDBC.
     * @throws SQLException si ocurre un error al conectar con la base de datos.
     */

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_feedback";
    private static final String USER = "root"; // Cambiá según tu configuración
    private static final String PASSWORD = "valentin1234"; // Cambiá según tu configuración

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
        return connection;
    }
}
