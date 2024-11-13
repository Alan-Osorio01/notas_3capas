package CAPA_LOGICA_NOTAS; // Declaración del paquete donde se encuentra esta clase

import java.util.ArrayList; // Importar la clase ArrayList
import java.sql.*; // Importar las clases necesarias para trabajar con bases de datos
import CAPA_DATO.Conexion; // Importar la clase Conexion del paquete CAPA_DATO

public class DatoNotas { // Declaración de la clase "DatoNotas"

    // Declaración de variables miembro para almacenar los datos
    private int codigo;
    private int id;
    private String nombre;
    private String correo;
    private String num;
    private String semestre;
    private float quiz;
    private float talleres;
    private float parcial;
    private float total;

    // Métodos para realizar operaciones de eliminación en la tabla tabla_datos_basicos
    public String EliminarDatosBasicos() {
        Conexion objmod = new Conexion();
        String cad = "DELETE FROM tabla_datos_basicos WHERE id='" + this.getId() + "'";
        return objmod.Ejecutar(cad);
    }

    // Métodos para realizar operaciones de eliminación en la tabla tabla_calificaciones
    public String EliminarCalificaciones() {
        Conexion objmod = new Conexion();
        String cad = "DELETE FROM tabla_calificaciones WHERE codigo='" + this.getCodigo() + "'";
        return objmod.Ejecutar(cad);
    }

    // Métodos para realizar operaciones de inserción en la tabla tabla_datos_basicos
    public String GrabarDatosBasicos() {
        Conexion objmod = new Conexion();
        String cad = "INSERT INTO tabla_datos_basicos (codigo, id, nombre, correo, num, semestre) VALUES ("
                + this.getCodigo() + ",'" + this.getId() + "','" + this.getNombre() + "','" + this.getCorreo() + "',"
                + this.getNum() + "," + this.getSemestre() + ")";
        return objmod.Ejecutar(cad);
    }

    // Métodos para realizar operaciones de inserción en la tabla tabla_calificaciones
    public String GrabarCalificaciones() {
        Conexion objmod = new Conexion();
        String cad = "INSERT INTO tabla_calificaciones (codigo, quiz, talleres, parcial) VALUES ("
                + this.getCodigo() + "," + this.getQuiz() + "," + this.getTalleres() + "," + this.getParcial() + ")";
        return objmod.Ejecutar(cad);
    }

    // Métodos para realizar operaciones de actualización en la tabla tabla_datos_basicos
    public String EditarDatosBasicos() {
        Conexion objmod = new Conexion();
        String cad = "UPDATE tabla_datos_basicos SET nombre='" + this.getNombre() +
               "', correo='" + this.getCorreo() + "', num=" + this.getNum() +
               ", semestre='" + this.getSemestre() + "', codigo=" + this.getCodigo() +
               " WHERE id='" + this.getId() + "'";
        return objmod.Ejecutar(cad);
    }

    // Métodos para realizar operaciones de actualización en la tabla tabla_calificaciones
    public String EditarCalificaciones() {
        Conexion objmod = new Conexion();
        String cad = "UPDATE tabla_calificaciones SET quiz=" + this.getQuiz() +
                   ", talleres=" + this.getTalleres() + ", parcial=" + this.getParcial() +
                    " WHERE codigo=" + this.getCodigo();
        return objmod.Ejecutar(cad);
    }

    // Método para obtener una lista de datos básicos desde la tabla tabla_datos_basicos
    public ArrayList<DatoNotas> ListaDatosBasicos() {
        ArrayList<DatoNotas> listaDatosBasicos = new ArrayList<>();
        try {
            Conexion objmod = new Conexion();
            ResultSet tabla = objmod.Listar("SELECT * FROM tabla_datos_basicos");
            while (tabla.next()) {
                DatoNotas calificacion = new DatoNotas();
                calificacion.setCodigo(tabla.getInt("Codigo"));
                calificacion.setId(tabla.getInt("id"));
                calificacion.setNombre(tabla.getString("nombre"));
                calificacion.setCorreo(tabla.getString("correo"));
                calificacion.setNum(tabla.getString("num"));
                calificacion.setSemestre(tabla.getString("semestre"));
                listaDatosBasicos.add(calificacion);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaDatosBasicos;
    }

    // Método para obtener una lista de calificaciones desde la tabla tabla_calificaciones
    public ArrayList<DatoNotas> Listacalificaiones() {
        ArrayList<DatoNotas> listaCalificaciones = new ArrayList<>();
        try {
            Conexion objmod = new Conexion();
            ResultSet tabla = objmod.Listar("SELECT * FROM tabla_calificaciones");
            while (tabla.next()) {
                DatoNotas calificacion = new DatoNotas();
                calificacion.setCodigo(tabla.getInt("Codigo"));
                calificacion.setQuiz(tabla.getFloat("quiz"));
                calificacion.setTalleres(tabla.getFloat("talleres"));
                calificacion.setParcial(tabla.getFloat("parcial"));
                listaCalificaciones.add(calificacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCalificaciones;
    }

    // Métodos para establecer y obtener los valores de las variables miembro
    // (getters y setters)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public float getQuiz() {
        return quiz;
    }

    public void setQuiz(float quiz) {
        this.quiz = quiz;
    }

    public float getTalleres() {
        return talleres;
    }

    public void setTalleres(float talleres) {
        this.talleres = talleres;
    }

    public float getParcial() {
        return parcial;
    }

    public void setParcial(float parcial) {
        this.parcial = parcial;
    }

}
