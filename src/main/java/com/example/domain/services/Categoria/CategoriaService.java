package com.example.domain.services.Categoria;


import com.example.persistence.entities.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    Optional<Categoria> update(Long id, Categoria categoria);
    Optional<Categoria> delete(Long id);
}
