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
@Table(name = "estacionesPago")
public class EstacionPago {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "estacionPago")
    private List<MovCaja> movimientosCaja;

    // Constructor por defecto
    public EstacionPago() {
    }

    // Constructor con parámetros
    public EstacionPago(List<MovCaja> movimientosCaja) {
        this.movimientosCaja = movimientosCaja;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MovCaja> getMovimientosCaja() {
        return movimientosCaja;
    }

    public void setMovimientosCaja(List<MovCaja> movimientosCaja) {
        this.movimientosCaja = movimientosCaja;
    }
}
