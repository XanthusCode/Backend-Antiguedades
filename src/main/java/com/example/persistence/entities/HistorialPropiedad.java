package com.example.persistence.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Clase de entidad
@Entity
@Table(name = "historialPropiedades")
public class HistorialPropiedad {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Persona persona;

    // Constructor por defecto
    public HistorialPropiedad() {
    }

    // Constructor con parámetros
    public HistorialPropiedad(Persona persona) {
        this.persona = persona;
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
}
