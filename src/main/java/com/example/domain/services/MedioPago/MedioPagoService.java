package com.example.domain.services.MedioPago;


import com.example.persistence.entities.MedioPago;
import java.util.List;
import java.util.Optional;

public interface MedioPagoService {
    List<MedioPago> findAll();
    Optional<MedioPago> findById(Long id);
    MedioPago save(MedioPago medioPago);
    Optional<MedioPago> update(Long id, MedioPago medioPago);
    Optional<MedioPago> delete(Long id);
}
