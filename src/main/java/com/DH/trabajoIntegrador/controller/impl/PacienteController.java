package com.DH.trabajoIntegrador.controller.impl;

import com.DH.trabajoIntegrador.controller.IPacienteController;
import com.DH.trabajoIntegrador.entities.Paciente;
import com.DH.trabajoIntegrador.exception.BadRequestException;
import com.DH.trabajoIntegrador.exception.ResourceNotFoundException;
import com.DH.trabajoIntegrador.service.IPacienteService;
//import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/* aca se implementa swagger openapi

 * se reemplaza
 *          @ApiParam -> @Parameter
 */

//@Controller
@RestController
@RequestMapping("/pacientes")
public class PacienteController implements IPacienteController {

    @Autowired
    private IPacienteService iPacienteService;

    @GetMapping
    @Override
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(iPacienteService.listarPacientes());
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Paciente> buscarPaciente(@Parameter(example = "1") Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = iPacienteService.buscarPaciente(id);
        if(pacienteBuscado.isPresent())
            return ResponseEntity.ok(pacienteBuscado.get());
        else
            throw new ResourceNotFoundException("Paciente con ID=" + id + " no encontrado");
    }

    @PostMapping
    @Override
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) throws BadRequestException {
        if (Paciente.isValid(paciente))
            return ResponseEntity.ok(iPacienteService.guardarPaciente(paciente));
        else
            throw new BadRequestException("Datos incompletos. Los campos no pueden estar nulos");
    }

    @PutMapping(value = "/{id}",produces = "application/json")
    @Override
    public ResponseEntity<Paciente> actualizarPaciente(@Parameter(example = "1") Long id, @RequestBody Paciente paciente) throws ResourceNotFoundException {
        Optional<Paciente> pacienteParaActualizar = iPacienteService.buscarPaciente(id);
        if (pacienteParaActualizar.isPresent() && Paciente.isValid(pacienteParaActualizar.get())){
            return ResponseEntity.ok(iPacienteService.actualizarPaciente(id, paciente));
        }
        throw new ResourceNotFoundException("Paciente con ID=" + id + "no encontrado para actualizar");
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @Override
    public ResponseEntity<String> eliminarPaciente(@Parameter(example = "1") Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteBorrar = iPacienteService.buscarPaciente(id);
        if(pacienteBorrar.isPresent()){
            iPacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Paciente con ID=" + id + " eliminado");
        }
        else
            throw new ResourceNotFoundException("No se encontro el paciente con ID=" + id + " para eliminar");
    }
}
