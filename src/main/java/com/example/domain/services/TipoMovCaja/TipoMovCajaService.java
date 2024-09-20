package com.example.domain.services.TipoMovCaja;


import com.example.persistence.entities.TipoMovCaja;
import java.util.List;
import java.util.Optional;

public interface TipoMovCajaService {
    List<TipoMovCaja> findAll();
    Optional<TipoMovCaja> findById(Long id);
    TipoMovCaja save(TipoMovCaja tipoMovCaja);
    Optional<TipoMovCaja> update(Long id, TipoMovCaja tipoMovCaja);
    Optional<TipoMovCaja> delete(Long id);
}