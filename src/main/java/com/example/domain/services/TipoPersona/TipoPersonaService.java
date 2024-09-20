package com.example.domain.services.TipoPersona;


import com.example.persistence.entities.TipoPersona;
import java.util.List;
import java.util.Optional;

public interface TipoPersonaService {
    List<TipoPersona> findAll();
    Optional<TipoPersona> findById(Long id);
    TipoPersona save(TipoPersona tipoPersona);
    Optional<TipoPersona> update(Long id, TipoPersona tipoPersona);
    Optional<TipoPersona> delete(Long id);
}