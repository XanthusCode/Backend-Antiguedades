package com.example.domain.services.Pais;


import com.example.persistence.entities.Pais;
import java.util.List;
import java.util.Optional;

public interface PaisService {
    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Pais save(Pais pais);
    Optional<Pais> update(Long id, Pais pais);
    Optional<Pais> delete(Long id);
}
