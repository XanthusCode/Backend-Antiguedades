package com.example.domain.services.Galeria;


import com.example.persistence.entities.Galeria;
import java.util.List;
import java.util.Optional;

public interface GaleriaService {
    List<Galeria> findAll();
    Optional<Galeria> findById(Long id);
    Galeria save(Galeria galeria);
    Optional<Galeria> update(Long id, Galeria galeria);
    Optional<Galeria> delete(Long id);
}
