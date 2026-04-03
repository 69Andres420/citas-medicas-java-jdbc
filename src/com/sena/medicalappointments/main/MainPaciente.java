package com.sena.medicalappointments.main;

import com.sena.medicalappointments.model.Paciente;
import com.sena.medicalappointments.repository.PacienteRepository;

public class MainPaciente {
    public static void main(String[] args) {
        PacienteRepository repo = new PacienteRepository();

        // INSERTAR
        Paciente paciente = new Paciente();
        paciente.setTipoDocumento("CC");
        paciente.setNumeroDocumento("123456789");
        paciente.setNombres("Andres");
        paciente.setApellidos("Sanchez");
        paciente.setTelefono("3001234567");
        paciente.setCorreo("andres@email.com");
        paciente.setDireccion("Bogota");
        paciente.setEstado("Activo");

        boolean insertado = repo.insertar(paciente);
        System.out.println("Insertado: " + insertado);

        // LISTAR
        System.out.println("\nListado inicial de pacientes:");
        for (Paciente p : repo.listar()) {
            System.out.println(p.getIdPaciente() + " - " + p.getNombres() + " " + p.getApellidos());
        }

        // ACTUALIZAR PRIMER PACIENTE
        if (!repo.listar().isEmpty()) {
            Paciente primero = repo.listar().get(0);
            primero.setTelefono("3119998888");
            primero.setCorreo("actualizado@email.com");

            boolean actualizado = repo.actualizar(primero);
            System.out.println("\nActualizado: " + actualizado);
        }

        // LISTAR DESPUÉS DE ACTUALIZAR
        System.out.println("\nListado después de actualizar:");
        for (Paciente p : repo.listar()) {
            System.out.println(
                p.getIdPaciente() + " - " +
                p.getNombres() + " " +
                p.getApellidos() + " - " +
                p.getTelefono() + " - " +
                p.getCorreo()
            );
        }

        // ELIMINAR ÚLTIMO PACIENTE
        if (!repo.listar().isEmpty()) {
            int ultimoId = repo.listar().get(repo.listar().size() - 1).getIdPaciente();
            boolean eliminado = repo.eliminar(ultimoId);
            System.out.println("\nEliminado: " + eliminado);
        }

        // LISTAR FINAL
        System.out.println("\nListado final de pacientes:");
        for (Paciente p : repo.listar()) {
            System.out.println(p.getIdPaciente() + " - " + p.getNombres() + " " + p.getApellidos());
        }
    }
}
