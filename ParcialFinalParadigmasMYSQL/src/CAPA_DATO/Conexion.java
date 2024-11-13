package CAPA_DATO; // Declaración del paquete donde se encuentra esta clase

import java.sql.*; // Importar las clases necesarias para trabajar con bases de datos

public class Conexion { // Declaración de la clase "Conexion"

    private final String url = "jdbc:mysql://localhost:3306/sistemaC"; // URL de conexión a la base de datos
    private final String user = "root"; // Usuario de la base de datos
    private final String pwd = " "; // Contraseña de la base de datos

    public Conexion() {
        // Constructor de la clase (vacío en este caso)
    }

    public ResultSet Listar(String Cad) {
        try {
            Connection cn = DriverManager.getConnection(url, user, pwd); // Establecer la conexión a la base de datos
            PreparedStatement da = cn.prepareStatement(Cad); // Crear una declaración preparada
            ResultSet tbl = da.executeQuery(); // Ejecutar la consulta y obtener los resultados (ResultSet)
            return tbl; // Devolver el ResultSet
        } catch (SQLException e) { // Manejo de excepciones en caso de error
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage()); // Mostrar un mensaje de error
            return null; // Devolver nulo en caso de error
        }
    }

    public String Ejecutar(String Cad) {
        try {
            Connection cn = DriverManager.getConnection(url, user, pwd); // Establecer la conexión a la base de datos
            PreparedStatement da = cn.prepareStatement(Cad); // Crear una declaración preparada
            int r = da.executeUpdate(); // Ejecutar una actualización (inserción, actualización o eliminación)
            return "Se afectaron " + r + " filas"; // Devolver un mensaje con la cantidad de filas afectadas
        } catch (SQLException e) { // Manejo de excepciones en caso de error
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage()); // Mostrar un mensaje de error
            return "Error " + e.getMessage(); // Devolver un mensaje de error
        }
    }
}
