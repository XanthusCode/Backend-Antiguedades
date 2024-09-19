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
@Table(name = "tiposDireccion")
public class TipoDireccion {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tipoDireccion")
    private List<DireccionPersona> direcciones;

    // Constructor por defecto
    public TipoDireccion() {
    }

    // Constructor con parámetros
    public TipoDireccion(List<DireccionPersona> direcciones) {
        this.direcciones = direcciones;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DireccionPersona> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionPersona> direcciones) {
        this.direcciones = direcciones;
    }
}
