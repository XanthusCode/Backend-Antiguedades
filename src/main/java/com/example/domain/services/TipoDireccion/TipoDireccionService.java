package com.example.domain.services.TipoDireccion;


import com.example.persistence.entities.TipoDireccion;
import java.util.List;
import java.util.Optional;

public interface TipoDireccionService {
    List<TipoDireccion> findAll();
    Optional<TipoDireccion> findById(Long id);
    TipoDireccion save(TipoDireccion tipoDireccion);
    Optional<TipoDireccion> update(Long id, TipoDireccion tipoDireccion);
    Optional<TipoDireccion> delete(Long id);
}