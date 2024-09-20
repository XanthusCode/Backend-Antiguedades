package com.example.domain.services.ContactoPersona;


import com.example.persistence.entities.ContactoPersona;
import com.example.domain.repository.ContactoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoPersonaImpl implements ContactoPersonaService {

    private final ContactoPersonaRepository repository;

    @Autowired
    public ContactoPersonaImpl(ContactoPersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ContactoPersona> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ContactoPersona> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ContactoPersona save(ContactoPersona contactoPersona) {
        return repository.save(contactoPersona);
    }

    @Transactional
    @Override
    public Optional<ContactoPersona> update(Long id, ContactoPersona contactoPersona) {
        return repository.findById(id).map(existingContactoPersona -> {
            //existingContactoPersona.setNombre(contactoPersona.getNombre());
            //existingContactoPersona.setEmail(contactoPersona.getEmail());
            //existingContactoPersona.setTelefono(contactoPersona.getTelefono());
            return repository.save(existingContactoPersona);
        });
    }

    @Transactional
    @Override
    public Optional<ContactoPersona> delete(Long id) {
        return repository.findById(id).map(contactoPersona -> {
            repository.delete(contactoPersona);
            return contactoPersona;
        });
    }
}