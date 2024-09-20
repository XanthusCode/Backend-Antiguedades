package com.example.domain.services.ClaseContacto;


import com.example.persistence.entities.ClaseContacto;
import java.util.List;
import java.util.Optional;

public interface ClaseContactoService {
    List<ClaseContacto> findAll();
    Optional<ClaseContacto> findById(Long id);
    ClaseContacto save(ClaseContacto claseContacto);
    Optional<ClaseContacto> update(Long id, ClaseContacto claseContacto);
    Optional<ClaseContacto> delete(Long id);
}
