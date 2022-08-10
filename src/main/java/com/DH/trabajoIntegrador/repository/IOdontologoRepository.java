package com.DH.trabajoIntegrador.repository;

import com.DH.trabajoIntegrador.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
    @Query(value = "Select * from ODONTOLOGOS where matricula= ?1", nativeQuery = true)
    Optional<Odontologo> buscarOdontologoPorMatricula(Integer matricula);
}
