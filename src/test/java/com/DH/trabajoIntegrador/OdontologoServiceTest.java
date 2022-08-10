package com.DH.trabajoIntegrador;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.repository.IOdontologoRepository;
import com.DH.trabajoIntegrador.service.IOdontologoService;
import com.DH.trabajoIntegrador.service.impl.OdontologoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceTest {
    final Integer matricula = 5565;

    @InjectMocks
    OdontologoService odontologoServiceMock;

    @Mock
    IOdontologoRepository iOdontologoRepositoryMock;

    @Autowired
    IOdontologoService iOdontologoService;

//    @Test
//    @Order(1)
//    public void testPr(){
//        assertTrue(true);
//    }

    @Test
    @Order(1)
    public void shouldCreateOdontologo(){
        when(iOdontologoRepositoryMock.save(buildOdontologo())).thenReturn(buildOdontologo());
        Odontologo o = odontologoServiceMock.guardarOdontologo(buildOdontologo());
        assertEquals(o.getClass(), buildOdontologo().getClass());
        assertEquals(o, buildOdontologo());
    }

    @Test
    @Order(2)
    public void agregarOdontologoTest(){

        Odontologo odontoDePrueba= new Odontologo("Mariana","Figueroa", matricula);
        iOdontologoService.guardarOdontologo(odontoDePrueba);
        //busqueda del nuevo elemento
        Optional<Odontologo> odontoDePruebaRecuperado = iOdontologoService.buscarOdontologoPorMatricula(matricula);
        assertTrue(odontoDePruebaRecuperado.isPresent());
    }

    @Test
    @Order(3)
    public void listarOdontologosTest(){
        List<Odontologo> odontologos = iOdontologoService.listarOdontologos();
        assertTrue(odontologos.size()>0);
    }

    @Test
    @Order(4)
    public void actualizarOdontologoTest(){
        final String nuevoApellido = "Sierra";
        Optional<Odontologo> odontoDePruebaRecuperado = iOdontologoService.buscarOdontologoPorMatricula(matricula);
        if(odontoDePruebaRecuperado.isPresent()){
            odontoDePruebaRecuperado.get().setApellido(nuevoApellido);
            iOdontologoService.actualizarOdontologo(odontoDePruebaRecuperado.get().getId(), odontoDePruebaRecuperado.get());
            Optional<Odontologo> odontologoRecuperado = iOdontologoService.buscarOdontologo(odontoDePruebaRecuperado.get().getId());
            assertTrue(odontologoRecuperado.isPresent() && odontologoRecuperado.get().getApellido().equals(nuevoApellido));
        }
        else
            assertTrue(false);
    }

    @Test
    @Order(5)
    public void eliminarOdontologoTest(){
        Optional<Odontologo> odontologoParaEliminar = iOdontologoService.buscarOdontologoPorMatricula(matricula);
        if(odontologoParaEliminar.isPresent()){
            iOdontologoService.eliminarOdontologo(odontologoParaEliminar.get().getId());
            odontologoParaEliminar = iOdontologoService.buscarOdontologoPorMatricula(matricula);
            assertFalse(odontologoParaEliminar.isPresent());
        }
        else
            assertTrue(false);
    }

    private Odontologo buildOdontologo(){
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1l);
        odontologo.setApellido("Jimenez");
        odontologo.setNombre("Carlos");
        odontologo.setMatricula(65432);
        return odontologo;
    }
}
