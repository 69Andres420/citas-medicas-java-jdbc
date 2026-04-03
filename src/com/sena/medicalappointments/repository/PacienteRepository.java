package com.sena.medicalappointments.repository;

import com.sena.medicalappointments.config.ConexionBD;
import com.sena.medicalappointments.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    public boolean insertar(Paciente paciente) {
        String sql = "INSERT INTO paciente(tipo_documento, numero_documento, nombres, apellidos, telefono, correo, direccion, estado) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, paciente.getTipoDocumento());
            ps.setString(2, paciente.getNumeroDocumento());
            ps.setString(3, paciente.getNombres());
            ps.setString(4, paciente.getApellidos());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getCorreo());
            ps.setString(7, paciente.getDireccion());
            ps.setString(8, paciente.getEstado());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (Connection conexion = ConexionBD.conectar();
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("id_paciente"));
                p.setTipoDocumento(rs.getString("tipo_documento"));
                p.setNumeroDocumento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                p.setDireccion(rs.getString("direccion"));
                p.setEstado(rs.getString("estado"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizar(Paciente paciente) {
        String sql = "UPDATE paciente SET tipo_documento=?, numero_documento=?, nombres=?, apellidos=?, telefono=?, correo=?, direccion=?, estado=? WHERE id_paciente=?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, paciente.getTipoDocumento());
            ps.setString(2, paciente.getNumeroDocumento());
            ps.setString(3, paciente.getNombres());
            ps.setString(4, paciente.getApellidos());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getCorreo());
            ps.setString(7, paciente.getDireccion());
            ps.setString(8, paciente.getEstado());
            ps.setInt(9, paciente.getIdPaciente());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idPaciente) {
        String sql = "DELETE FROM paciente WHERE id_paciente=?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idPaciente);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
