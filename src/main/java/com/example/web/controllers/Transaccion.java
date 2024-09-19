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
@Table(name = "transacciones")
public class Transaccion {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private TipoTransaccion tipoTransaccion;

    @OneToMany(mappedBy = "transaccion")
    private List<DetalleTransaccion> detalles;

    @OneToMany(mappedBy = "transaccion")
    private List<TransaccionMedioPago> mediosPago;

    @OneToMany(mappedBy = "transaccion")
    private List<Despacho> despacho;

    // Constructor por defecto
    public Transaccion() {
    }

    // Constructor con parámetros
    public Transaccion(Persona persona, TipoTransaccion tipoTransaccion, List<DetalleTransaccion> detalles, List<TransaccionMedioPago> mediosPago, List<Despacho> despachos) {
        this.persona = persona;
        this.tipoTransaccion = tipoTransaccion;
        this.detalles = detalles;
        this.mediosPago = mediosPago;
        this.despacho = despachos;
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

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public List<DetalleTransaccion> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleTransaccion> detalles) {
        this.detalles = detalles;
    }

    public List<TransaccionMedioPago> getMediosPago() {
        return mediosPago;
    }

    public void setMediosPago(List<TransaccionMedioPago> mediosPago) {
        this.mediosPago = mediosPago;
    }

    public List<Despacho> getDespachos() {
        return despacho;
    }

    public void setDespachos(List<Despacho> despachos) {
        this.despacho = despachos;
    }
}
