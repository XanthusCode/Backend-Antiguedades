package com.example.domain.services.DireccionPersona;

import com.example.persistence.entities.DireccionPersona;
import java.util.List;
import java.util.Optional;

public interface DireccionPersonaService {
    List<DireccionPersona> findAll();
    Optional<DireccionPersona> findById(Long id);
    DireccionPersona save(DireccionPersona direccionPersona);
    Optional<DireccionPersona> update(Long id, DireccionPersona direccionPersona);
    Optional<DireccionPersona> delete(Long id);
}