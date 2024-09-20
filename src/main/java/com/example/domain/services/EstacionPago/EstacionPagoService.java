package com.example.domain.services.EstacionPago;


import com.example.persistence.entities.EstacionPago;
import java.util.List;
import java.util.Optional;

public interface EstacionPagoService {
    List<EstacionPago> findAll();
    Optional<EstacionPago> findById(Long id);
    EstacionPago save(EstacionPago estacionPago);
    Optional<EstacionPago> update(Long id, EstacionPago estacionPago);
    Optional<EstacionPago> delete(Long id);
}