package com.DH.trabajoIntegrador.service.impl;

import com.DH.trabajoIntegrador.entities.Turno;
import com.DH.trabajoIntegrador.repository.ITurnoRespository;
import com.DH.trabajoIntegrador.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("TurnoService")
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRespository iTurnoRespository;

    @Override
    public List<Turno> listarTurnos() {
        return iTurnoRespository.findAll();
    }

    @Override
    public Optional<Turno> buscarTurnoById(Long id) {
        return iTurnoRespository.findById(id);
    }

    @Override
    public Turno crearTurno(Turno turno) {
        return iTurnoRespository.save(turno);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return iTurnoRespository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        iTurnoRespository.deleteById(id);
    }
}
