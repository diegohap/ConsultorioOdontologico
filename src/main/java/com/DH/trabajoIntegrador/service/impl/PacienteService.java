package com.DH.trabajoIntegrador.service.impl;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;
import com.DH.trabajoIntegrador.repository.IPacienteRepository;
import com.DH.trabajoIntegrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("PacienteService")
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Override
    public List<Paciente> listarPacientes() {
        return iPacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> buscarPaciente(Long id) {
        return iPacienteRepository.findById(id);
    }

    @Override
    public Optional<Paciente> buscarPacientePorDNI(Integer dni) {
        return iPacienteRepository.buscarPacientePorDNI(dni);
    }

    @Transactional
    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return iPacienteRepository.save(paciente);
    }
    @Transactional
    @Override
    public Paciente actualizarPaciente(Long id, Paciente paciente) {
        Paciente pacienteParaActualizar = buscarPaciente(id).get();
        pacienteParaActualizar.setApellido(paciente.getApellido());
        pacienteParaActualizar.setNombre(paciente.getNombre());
        pacienteParaActualizar.setDni(paciente.getDni());
        pacienteParaActualizar.setEmail(paciente.getEmail());
        pacienteParaActualizar.setFechaIngreso(paciente.getFechaIngreso());
        pacienteParaActualizar.setDomicilio(paciente.getDomicilio());
        return iPacienteRepository.save(pacienteParaActualizar);
    }
    @Transactional
    @Override
    public void eliminarPaciente(Long id) {
        iPacienteRepository.deleteById(id);
    }
}
