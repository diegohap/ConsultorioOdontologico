package com.DH.trabajoIntegrador.controller;

import com.DH.trabajoIntegrador.entities.Paciente;
import com.DH.trabajoIntegrador.exception.BadRequestException;
import com.DH.trabajoIntegrador.exception.ResourceNotFoundException;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/* aca se implementa swagger openapi
 * ref= https://springdoc.org/migrating-from-springfox.html
 * se reemplaza
 *          @Api -> @Tag
 *          @ApiOperation(value= "") -> @Operation(summary= "")
 */

@Tag(name = "Pacientes", description = "Api de consultas a Persona")
public interface IPacienteController {

    @Operation(summary = "Recupera todas los pacientes")
    ResponseEntity<List<Paciente>> listarPacientes();
    @Operation(summary  = "Recupera un paciente por id")
    ResponseEntity<Paciente> buscarPaciente(@PathVariable(value = "id") Long id) throws ResourceNotFoundException;
    @Operation(summary = "Crear un paciente")
    ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) throws BadRequestException;
    @Operation(summary = "Actualizar un paciente por id")
    ResponseEntity<Paciente> actualizarPaciente(@PathVariable(value = "id") final Long id, @RequestBody Paciente paciente) throws ResourceNotFoundException;
    @Operation(summary = "Borrar un paciente por id")
    ResponseEntity<String> eliminarPaciente(@PathVariable(value = "id") final Long id) throws ResourceNotFoundException;
}
