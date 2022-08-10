package com.DH.trabajoIntegrador.service;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    Optional<Paciente> buscarPaciente(Long id);
    Optional<Paciente> buscarPacientePorDNI(Integer dni);
    Paciente guardarPaciente(Paciente paciente);
    Paciente actualizarPaciente(Long id, Paciente paciente);
    void eliminarPaciente(Long id);
}
