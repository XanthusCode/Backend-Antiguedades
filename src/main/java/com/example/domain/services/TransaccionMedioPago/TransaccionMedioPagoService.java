package com.example.domain.services.TransaccionMedioPago;


import com.example.persistence.entities.TransaccionMedioPago;
import java.util.List;
import java.util.Optional;

public interface TransaccionMedioPagoService {
    List<TransaccionMedioPago> findAll();
    Optional<TransaccionMedioPago> findById(Long id);
    TransaccionMedioPago save(TransaccionMedioPago transaccionMedioPago);
    Optional<TransaccionMedioPago> update(Long id, TransaccionMedioPago transaccionMedioPago);
    Optional<TransaccionMedioPago> delete(Long id);
}
