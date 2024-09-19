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
@Table(name = "empresas")
public class Empresa {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "empresa")
    private List<Persona> personas;

    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;

    // Constructor por defecto
    public Empresa() {
    }

    // Constructor con parámetros
    public Empresa(List<Persona> personas, List<Sucursal> sucursales) {
        this.personas = personas;
        this.sucursales = sucursales;
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

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
