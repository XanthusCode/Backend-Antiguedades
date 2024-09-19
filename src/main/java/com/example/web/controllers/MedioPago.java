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
@Table(name = "mediosPago")
public class MedioPago {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "medioPago")
    private List<TransaccionMedioPago> transaccionesMedioPago;

    // Constructor por defecto
    public MedioPago() {
    }

    // Constructor con parámetros
    public MedioPago(List<TransaccionMedioPago> transaccionesMedioPago) {
        this.transaccionesMedioPago = transaccionesMedioPago;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TransaccionMedioPago> getTransaccionesMedioPago() {
        return transaccionesMedioPago;
    }

    public void setTransaccionesMedioPago(List<TransaccionMedioPago> transaccionesMedioPago) {
        this.transaccionesMedioPago = transaccionesMedioPago;
    }
}
