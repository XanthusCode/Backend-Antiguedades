package com.example.domain.services.Persona;


import com.example.persistence.entities.Persona;
import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> findAll();
    Optional<Persona> findById(Long id);
    Persona save(Persona persona);
    Optional<Persona> update(Long id, Persona persona);
    Optional<Persona> delete(Long id);
}