package com.sena.medicalappointments.config;

import java.sql.Connection;
import java.sql.DriverManager;
import org.sqlite.JDBC;

public class ConexionBD {

    private static final String URL = "jdbc:sqlite:citas_medicas.db";

    public static Connection conectar() {
    try {
        // Forzar carga del driver correctamente
        DriverManager.registerDriver(new JDBC());

        Connection conexion = DriverManager.getConnection(URL);
        System.out.println("Conexion exitosa a SQLite");
        return conexion;
          } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());
            return null;
        }
    }
}
