package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Clase de entidad
@Entity
@Table(name = "movCajas")
public class MovCaja {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estacion_pago_id")
    private EstacionPago estacionPago;

    @ManyToOne
    private TipoMovCaja tipoMovCaja;

    // Constructor por defecto
    public MovCaja() {
    }

    // Constructor con parámetros
    public MovCaja(EstacionPago estacionPago, TipoMovCaja tipoMovCaja) {
        this.estacionPago = estacionPago;
        this.tipoMovCaja = tipoMovCaja;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstacionPago getEstacionPago() {
        return estacionPago;
    }

    public void setEstacionPago(EstacionPago estacionPago) {
        this.estacionPago = estacionPago;
    }

    public TipoMovCaja getTipoMovCaja() {
        return tipoMovCaja;
    }

    public void setTipoMovCaja(TipoMovCaja tipoMovCaja) {
        this.tipoMovCaja = tipoMovCaja;
    }
}
