package com.DH.trabajoIntegrador.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> tratamientoErrorResourceNotFound(ResourceNotFoundException rnfe, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND -> Detalle: "+ rnfe.getMessage());
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> tratamientoErrorBadRequest(BadRequestException bre, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST -> Detalle: "+ bre.getMessage());
    }
}
