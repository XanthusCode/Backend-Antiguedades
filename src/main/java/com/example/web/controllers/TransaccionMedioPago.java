package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Clase de entidad
@Entity
@Table(name = "transaccionesMediosPago")
public class TransaccionMedioPago {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Transaccion transaccion;

    @ManyToOne
    private MedioPago medioPago;

    // Constructor por defecto
    public TransaccionMedioPago() {
    }

    // Constructor con parámetros
    public TransaccionMedioPago(Transaccion transaccion, MedioPago medioPago) {
        this.transaccion = transaccion;
        this.medioPago = medioPago;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }
}
