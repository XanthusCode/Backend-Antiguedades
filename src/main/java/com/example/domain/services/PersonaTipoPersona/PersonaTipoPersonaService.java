package com.example.domain.services.PersonaTipoPersona;


import com.example.persistence.entities.PersonaTipoPersona;
import java.util.List;
import java.util.Optional;

public interface PersonaTipoPersonaService {
    List<PersonaTipoPersona> findAll();
    Optional<PersonaTipoPersona> findById(Long id);
    PersonaTipoPersona save(PersonaTipoPersona personaTipoPersona);
    Optional<PersonaTipoPersona> update(Long id, PersonaTipoPersona personaTipoPersona);
    Optional<PersonaTipoPersona> delete(Long id);
}
