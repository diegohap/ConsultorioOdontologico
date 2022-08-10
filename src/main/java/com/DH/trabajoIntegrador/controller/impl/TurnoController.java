package com.DH.trabajoIntegrador.controller.impl;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;
import com.DH.trabajoIntegrador.entities.Turno;
import com.DH.trabajoIntegrador.exception.BadRequestException;
import com.DH.trabajoIntegrador.exception.ResourceNotFoundException;
import com.DH.trabajoIntegrador.service.IOdontologoService;
import com.DH.trabajoIntegrador.service.IPacienteService;
import com.DH.trabajoIntegrador.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final ITurnoService iTurnoService;
    private final IPacienteService iPacienteService;
    private final IOdontologoService iOdontologoService;

    @Autowired
    public TurnoController(@Qualifier("TurnoService") ITurnoService iTurnoService,
                           @Qualifier("PacienteService") IPacienteService iPacienteService,
                           @Qualifier("OdontologoService") IOdontologoService iOdontologoService) {
        this.iTurnoService = iTurnoService;
        this.iPacienteService = iPacienteService;
        this.iOdontologoService = iOdontologoService;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(iTurnoService.listarTurnos());
    }

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody Turno turno) throws BadRequestException, ResourceNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if(!Turno.isValid(turno)){
            throw new BadRequestException("Datos incompletos. Los campos no pueden estar nulos");
        }

        Optional<Paciente> pacienteBuscado = iPacienteService.buscarPaciente(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = iOdontologoService.buscarOdontologo(turno.getOdontologo().getId());

        if(pacienteBuscado.isEmpty() || odontologoBuscado.isEmpty())
            throw new ResourceNotFoundException("El odontologo o el paciente no se encuentran registrados");

        Turno turnoNuevo = iTurnoService.crearTurno(turno);
        turnoNuevo.setPaciente(pacienteBuscado.get());
        turnoNuevo.setOdontologo(odontologoBuscado.get());

        return new ResponseEntity<>(turnoNuevo, headers, HttpStatus.CREATED);

    }

}
