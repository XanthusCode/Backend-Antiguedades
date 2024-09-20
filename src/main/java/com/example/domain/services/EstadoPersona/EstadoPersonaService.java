package com.example.domain.services.EstadoPersona;

import com.example.persistence.entities.EstadoPersona;
import java.util.List;
import java.util.Optional;

public interface EstadoPersonaService {
    List<EstadoPersona> findAll();
    Optional<EstadoPersona> findById(Long id);
    EstadoPersona save(EstadoPersona estadoPersona);
    Optional<EstadoPersona> update(Long id, EstadoPersona estadoPersona);
    Optional<EstadoPersona> delete(Long id);
}
