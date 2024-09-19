package com.example.persistence.entities;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Persona persona;

    private String puesto;
    private Date fechaContratacion;

    // Constructor por defecto
    public Empleado() {
    }

    // Constructor con parámetros
    public Empleado(Persona persona, String puesto, Date fechaContratacion) {
        this.persona = persona;
        this.puesto = puesto;
        this.fechaContratacion = fechaContratacion;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
