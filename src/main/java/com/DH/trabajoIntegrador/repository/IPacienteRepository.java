package com.DH.trabajoIntegrador.repository;

import com.DH.trabajoIntegrador.entities.Odontologo;
import com.DH.trabajoIntegrador.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    @Query(value = "Select * from PACIENTES where dni= ?1", nativeQuery = true)
    Optional<Paciente> buscarPacientePorDNI(Integer dni);
}
