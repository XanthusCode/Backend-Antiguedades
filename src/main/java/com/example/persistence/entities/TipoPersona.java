package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

// Clase de entidad
@Entity
@Table(name = "tiposPersona")
public class TipoPersona {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tipoPersona")
    private List<Persona> personas;

    @OneToMany(mappedBy = "tipoPersona")
    private List<PersonaTipoPersona> personaTipoPersonas;

    // Constructor por defecto
    public TipoPersona() {
    }

    // Constructor con parámetros
    public TipoPersona(List<Persona> personas, List<PersonaTipoPersona> personaTipoPersonas) {
        this.personas = personas;
        this.personaTipoPersonas = personaTipoPersonas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<PersonaTipoPersona> getPersonaTipoPersonas() {
        return personaTipoPersonas;
    }

    public void setPersonaTipoPersonas(List<PersonaTipoPersona> personaTipoPersonas) {
        this.personaTipoPersonas = personaTipoPersonas;
    }
}
