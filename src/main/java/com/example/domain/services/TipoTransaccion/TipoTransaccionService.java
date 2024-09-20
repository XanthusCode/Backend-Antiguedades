package com.example.domain.services.TipoTransaccion;

import com.example.persistence.entities.TipoTransaccion;
import java.util.List;
import java.util.Optional;

public interface TipoTransaccionService {
    List<TipoTransaccion> findAll();
    Optional<TipoTransaccion> findById(Long id);
    TipoTransaccion save(TipoTransaccion tipoTransaccion);
    Optional<TipoTransaccion> update(Long id, TipoTransaccion tipoTransaccion);
    Optional<TipoTransaccion> delete(Long id);
}