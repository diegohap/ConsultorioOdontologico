package com.DH.trabajoIntegrador;

import com.DH.trabajoIntegrador.entities.Domicilio;
import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;
import com.DH.trabajoIntegrador.repository.IDomicilioRepository;
import com.DH.trabajoIntegrador.service.IPacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
public class PacienteServiceTest {

//    final Integer dni = 99999999;
//    @Autowired
//    IPacienteService iPacienteService;
//
//    @Autowired
//    IDomicilioRepository iDomicilioRepository;
//
//
//    @Test
//    @Order(1)
//    public void agregarPacienteTest(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse("2021-06-02", formatter);
//
//        Domicilio domicilio = iDomicilioRepository.findById(1l).get();
//
//        Paciente pacienteDePrueba= new Paciente("Fernandez", "Rosa", "feros@gmail.com", dni, localDate, new Domicilio());
//        iPacienteService.guardarPaciente(pacienteDePrueba);
//        //busqueda del nuevo elemento
//        Optional<Paciente> pacienteDePruebaRecuperado = iPacienteService.buscarPacientePorDNI(dni);
//        assertTrue(pacienteDePruebaRecuperado.isPresent());
//    }

//    @Test
//    @Order(2)
//    public void listarPacienteTest(){
//        List<Paciente> pacientes = iPacienteService.listarPacientes();
//        assertTrue(pacientes.size()>0);
//    }
//
//    @Test
//    @Order(3)
//    public void actualizarPacienteTest(){
//        final String nuevoApellido = "Sierra";
//        Optional<Paciente> pacienteDePruebaRecuperado = iPacienteService.buscarPacientePorDNI(dni);
//        if(pacienteDePruebaRecuperado.isPresent()){
//            pacienteDePruebaRecuperado.get().setApellido(nuevoApellido);
//            iPacienteService.actualizarPaciente(pacienteDePruebaRecuperado.get().getId(), pacienteDePruebaRecuperado.get());
//            Optional<Paciente> pacienteRecuperado = iPacienteService.buscarPaciente(pacienteDePruebaRecuperado.get().getId());
//            assertTrue(pacienteRecuperado.isPresent() && pacienteRecuperado.get().getApellido().equals(nuevoApellido));
//        }
//        else
//            assertTrue(false);
//    }
//
//    @Test
//    @Order(4)
//    public void eliminarPacienteTest(){
//        Optional<Paciente> pacienteParaEliminar = iPacienteService.buscarPacientePorDNI(dni);
//        if(pacienteParaEliminar.isPresent()){
//            iPacienteService.eliminarPaciente(pacienteParaEliminar.get().getId());
//            pacienteParaEliminar = iPacienteService.buscarPacientePorDNI(dni);
//            assertFalse(pacienteParaEliminar.isPresent());
//        }
//        else
//            assertTrue(false);
//    }
}
