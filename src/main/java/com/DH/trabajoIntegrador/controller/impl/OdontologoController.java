package com.DH.trabajoIntegrador.controller.impl;

import com.DH.trabajoIntegrador.controller.IOdontologoController;
import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.exception.BadRequestException;
import com.DH.trabajoIntegrador.exception.ResourceNotFoundException;
import com.DH.trabajoIntegrador.service.IOdontologoService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController implements IOdontologoController {

    @Autowired
    IOdontologoService iOdontologoService;

    @GetMapping
    @Override
    public ResponseEntity<List<Odontologo>> listarOdontologos() {
        return ResponseEntity.ok(iOdontologoService.listarOdontologos());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Odontologo> buscarOdontologo(@ApiParam(example = "1") Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = iOdontologoService.buscarOdontologo(id);
        if(odontologoBuscado.isPresent())
            return ResponseEntity.ok(odontologoBuscado.get());
        else
            throw new ResourceNotFoundException("Paciente con ID=" + id + " no encontrado");
    }

    @PostMapping
    @Override
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException {
        if(Odontologo.isValid(odontologo)){
            return ResponseEntity.ok(iOdontologoService.guardarOdontologo(odontologo));
        }
        throw new BadRequestException("Datos incompletos. Los campos no pueden estar nulos");
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Odontologo> actualizarOdontologo(@ApiParam(value = "id", example = "1") Long id, @RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoParaActualizar = iOdontologoService.buscarOdontologo(id);
        if (odontologoParaActualizar.isPresent() && Odontologo.isValid(odontologoParaActualizar.get())){
            return ResponseEntity.ok(iOdontologoService.actualizarOdontologo(id, odontologo));
        }
        throw new ResourceNotFoundException("Paciente con ID=" + id + "no encontrado para actualizar");
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @Override
    public ResponseEntity<String> eliminarOdontologo(@ApiParam(example = "1") Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBorrar = iOdontologoService.buscarOdontologo(id);
        if(odontologoBorrar.isPresent()){
            iOdontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Odontologo con ID=" + id + " eliminado");
        }
        else
            throw new ResourceNotFoundException("No se encontro el paciente con ID=" + id + " para eliminar");
    }
}
