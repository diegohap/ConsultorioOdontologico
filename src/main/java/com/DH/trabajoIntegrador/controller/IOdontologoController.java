package com.DH.trabajoIntegrador.controller;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.exception.BadRequestException;
import com.DH.trabajoIntegrador.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(value = "Api con la tabla Odontologo", tags = "Api de consultas a Odontologo")
public interface IOdontologoController {

    @ApiOperation(value = "Recupera todas los odontologos")
    ResponseEntity<List<Odontologo>> listarOdontologos();
    @ApiOperation(value = "Recupera un odontologo por id")
    ResponseEntity<Odontologo> buscarOdontologo(@PathVariable(value = "id") Long id) throws ResourceNotFoundException;
    @ApiOperation(value = "Crear un odontologo")
    ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException;
    @ApiOperation(value = "Actualizar un odontologo por id")
    ResponseEntity<Odontologo> actualizarOdontologo(@PathVariable(value = "id") final Long id, @RequestBody Odontologo odontologo) throws ResourceNotFoundException;
    @ApiOperation(value = "Borrar un odontologo por id")
    ResponseEntity<String> eliminarOdontologo(@PathVariable(value = "id") final Long id) throws ResourceNotFoundException;
}
