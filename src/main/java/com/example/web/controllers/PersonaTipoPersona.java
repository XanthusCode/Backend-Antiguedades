package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Clase de entidad
@Entity
@Table(name = "personasTiposPersona")
public class PersonaTipoPersona {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private TipoPersona tipoPersona;

    // Constructor por defecto
    public PersonaTipoPersona() {
    }

    // Constructor con parámetros
    public PersonaTipoPersona(Persona persona, TipoPersona tipoPersona) {
        this.persona = persona;
        this.tipoPersona = tipoPersona;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
