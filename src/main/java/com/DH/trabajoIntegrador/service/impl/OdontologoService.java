package com.DH.trabajoIntegrador.service.impl;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;
import com.DH.trabajoIntegrador.repository.IOdontologoRepository;
import com.DH.trabajoIntegrador.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("OdontologoService")
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository iOdontologoRepository;

    @Override
    public List<Odontologo> listarOdontologos() {
        return iOdontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarOdontologo(Long id) {
        return iOdontologoRepository.findById(id);
    }

    @Override
    public Optional<Odontologo> buscarOdontologoPorMatricula(Integer matricula) {
        return iOdontologoRepository.buscarOdontologoPorMatricula(matricula);
    }

    @Transactional
    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }
    @Transactional
    @Override
    public Odontologo actualizarOdontologo(Long id, Odontologo odontologo) {
        Odontologo odontologoParaActualizar = buscarOdontologo(id).get();
        odontologoParaActualizar.setApellido(odontologo.getApellido());
        odontologoParaActualizar.setNombre(odontologo.getNombre());
        odontologoParaActualizar.setMatricula(odontologo.getMatricula());
        return iOdontologoRepository.save(odontologoParaActualizar);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        iOdontologoRepository.deleteById(id);
    }
}
