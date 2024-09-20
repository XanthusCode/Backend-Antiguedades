package com.example.domain.services.Persona;


import com.example.persistence.entities.Persona;
import com.example.domain.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaImpl implements PersonaService {

    private final PersonaRepository repository;

    @Autowired
    public PersonaImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Persona> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Transactional
    @Override
    public Optional<Persona> update(Long id, Persona persona) {
        return repository.findById(id).map(existingPersona -> {
            //existingPersona.setNombre(persona.getNombre());
            //existingPersona.setApellido(persona.getApellido());
            //existingPersona.setEmail(persona.getEmail());
            // Agrega otros campos según sea necesario
            return repository.save(existingPersona);
        });
    }

    @Transactional
    @Override
    public Optional<Persona> delete(Long id) {
        return repository.findById(id).map(persona -> {
            repository.delete(persona);
            return persona;
        });
    }
}
