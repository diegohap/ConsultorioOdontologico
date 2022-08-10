package com.DH.trabajoIntegrador.service;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();
    Optional<Odontologo> buscarOdontologo(Long id);
    Optional<Odontologo> buscarOdontologoPorMatricula(Integer matricula);
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo actualizarOdontologo(Long id, Odontologo odontologo);
    void eliminarOdontologo(Long id);
}
