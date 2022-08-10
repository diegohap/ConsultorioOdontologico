package com.DH.trabajoIntegrador.service;

import com.DH.trabajoIntegrador.entities.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    List<Turno> listarTurnos();
    Optional<Turno> buscarTurnoById(Long id);
    Turno crearTurno(Turno turno);
    Turno actualizarTurno(Turno turno);
    void eliminarTurno(Long id);

}
