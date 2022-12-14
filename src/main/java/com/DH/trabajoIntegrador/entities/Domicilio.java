package com.DH.trabajoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "DOMICILIOS")
public class Domicilio {
    @Id
    @JsonIgnore
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    @Column
    private String calle;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column
    private String localidad;
    @Column
    private String provincia;

//    @OneToOne(mappedBy = "domicilio")
//    @JsonIgnore
//    private Paciente paciente;
//
//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    }
//
//    public Paciente getPaciente() {
//        return paciente;
//    }


    public Domicilio() {
    }

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
