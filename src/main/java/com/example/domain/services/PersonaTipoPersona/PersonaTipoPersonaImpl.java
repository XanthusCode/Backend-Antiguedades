package com.example.domain.services.PersonaTipoPersona;


import com.example.persistence.entities.PersonaTipoPersona;
import com.example.domain.repository.PersonaTipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaTipoPersonaImpl implements PersonaTipoPersonaService {

    private final PersonaTipoPersonaRepository repository;

    @Autowired
    public PersonaTipoPersonaImpl(PersonaTipoPersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonaTipoPersona> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PersonaTipoPersona> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public PersonaTipoPersona save(PersonaTipoPersona personaTipoPersona) {
        return repository.save(personaTipoPersona);
    }

    @Transactional
    @Override
    public Optional<PersonaTipoPersona> update(Long id, PersonaTipoPersona personaTipoPersona) {
        return repository.findById(id).map(existingTipoPersona -> {
            //existingTipoPersona.setNombre(personaTipoPersona.getNombre());
            //existingTipoPersona.setDescripcion(personaTipoPersona.getDescripcion());
            return repository.save(existingTipoPersona);
        });
    }

    @Transactional
    @Override
    public Optional<PersonaTipoPersona> delete(Long id) {
        return repository.findById(id).map(personaTipoPersona -> {
            repository.delete(personaTipoPersona);
            return personaTipoPersona;
        });
    }
}