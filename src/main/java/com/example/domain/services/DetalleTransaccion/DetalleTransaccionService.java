package com.example.domain.services.DetalleTransaccion;


import com.example.persistence.entities.DetalleTransaccion;
import java.util.List;
import java.util.Optional;

public interface DetalleTransaccionService {
    List<DetalleTransaccion> findAll();
    Optional<DetalleTransaccion> findById(Long id);
    DetalleTransaccion save(DetalleTransaccion detalleTransaccion);
    Optional<DetalleTransaccion> update(Long id, DetalleTransaccion detalleTransaccion);
    Optional<DetalleTransaccion> delete(Long id);
}