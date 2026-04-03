package com.sena.medicalappointments.util;

import com.sena.medicalappointments.config.ConexionBD;
import java.sql.Connection;
import java.sql.Statement;

public class InicializarBD {
    public static void main(String[] args) {
        String sql = """
            CREATE TABLE IF NOT EXISTS paciente (
                id_paciente INTEGER PRIMARY KEY AUTOINCREMENT,
                tipo_documento TEXT NOT NULL,
                numero_documento TEXT NOT NULL UNIQUE,
                nombres TEXT NOT NULL,
                apellidos TEXT NOT NULL,
                telefono TEXT,
                correo TEXT,
                direccion TEXT,
                estado TEXT DEFAULT 'Activo'
            );
        """;

        try (Connection conexion = ConexionBD.conectar();
             Statement st = conexion.createStatement()) {

            st.execute(sql);
            System.out.println("Tabla paciente creada correctamente.");

        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
