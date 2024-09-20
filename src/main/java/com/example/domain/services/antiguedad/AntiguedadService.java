package com.example.domain.services.antiguedad;

import com.example.persistence.entities.*;
import java.util.List;
import java.util.Optional;

public interface AntiguedadService {
    List<Antiguedad> findAll();
    Optional<Antiguedad> findById(Long id);
    Antiguedad save(Antiguedad antiguedad);
    Optional<Antiguedad> update(Long id, Antiguedad antiguedad);
    Optional<Antiguedad> delete(Long id);
}
