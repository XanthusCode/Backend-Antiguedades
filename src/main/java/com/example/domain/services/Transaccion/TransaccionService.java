package com.example.domain.services.Transaccion;


import com.example.persistence.entities.Transaccion;
import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    List<Transaccion> findAll();
    Optional<Transaccion> findById(Long id);
    Transaccion save(Transaccion transaccion);
    Optional<Transaccion> update(Long id, Transaccion transaccion);
    Optional<Transaccion> delete(Long id);
}