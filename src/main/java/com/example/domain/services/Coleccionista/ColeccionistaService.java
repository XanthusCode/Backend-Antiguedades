package com.example.domain.services.Coleccionista;

import com.example.persistence.entities.Coleccionista;
import java.util.List;
import java.util.Optional;

public interface ColeccionistaService {
    List<Coleccionista> findAll();
    Optional<Coleccionista> findById(Long id);
    Coleccionista save(Coleccionista coleccionista);
    Optional<Coleccionista> update(Long id, Coleccionista coleccionista);
    Optional<Coleccionista> delete(Long id);
}