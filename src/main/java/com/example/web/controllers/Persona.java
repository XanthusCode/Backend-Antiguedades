package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

// Clase de entidad
@Entity
@Table(name = "personas")
public class Persona {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "persona")
    private List<DireccionPersona> direcciones;

    @OneToMany(mappedBy = "persona")
    private List<ContactoPersona> contactos;

    @ManyToOne
    private TipoPersona tipoPersona;

    @OneToMany(mappedBy = "persona")
    private List<Transaccion> transacciones;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private EstadoPersona estadoPersona;

    @ManyToOne
    private Ciudad ciudad;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(List<DireccionPersona> direcciones, List<ContactoPersona> contactos, TipoPersona tipoPersona,
                   List<Transaccion> transacciones, Empresa empresa, EstadoPersona estadoPersona, Ciudad ciudad) {
        this.direcciones = direcciones;
        this.contactos = contactos;
        this.tipoPersona = tipoPersona;
        this.transacciones = transacciones;
        this.empresa = empresa;
        this.estadoPersona = estadoPersona;
        this.ciudad = ciudad;
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

    public List<ContactoPersona> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoPersona> contactos) {
        this.contactos = contactos;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EstadoPersona getEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(EstadoPersona estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
