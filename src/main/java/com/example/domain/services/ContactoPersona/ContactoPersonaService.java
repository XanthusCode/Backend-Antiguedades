package com.example.domain.services.ContactoPersona;

import com.example.persistence.entities.ContactoPersona;
import java.util.List;
import java.util.Optional;

public interface ContactoPersonaService {
    List<ContactoPersona> findAll();
    Optional<ContactoPersona> findById(Long id);
    ContactoPersona save(ContactoPersona contactoPersona);
    Optional<ContactoPersona> update(Long id, ContactoPersona contactoPersona);
    Optional<ContactoPersona> delete(Long id);
}