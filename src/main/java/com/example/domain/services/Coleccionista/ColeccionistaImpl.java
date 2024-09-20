package com.example.domain.services.Coleccionista;


import com.example.persistence.entities.Coleccionista;
import com.example.domain.repository.ColeccionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ColeccionistaImpl implements ColeccionistaService {

    private final ColeccionistaRepository repository;

    @Autowired
    public ColeccionistaImpl(ColeccionistaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Coleccionista> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Coleccionista> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Coleccionista save(Coleccionista coleccionista) {
        return repository.save(coleccionista);
    }

    @Transactional
    @Override
    public Optional<Coleccionista> update(Long id, Coleccionista coleccionista) {
        return repository.findById(id).map(existingColeccionista -> {
           // existingColeccionista.setNombre(coleccionista.getNombre());
            //existingColeccionista.setEmail(coleccionista.getEmail());
           // existingColeccionista.setTelefono(coleccionista.getTelefono());
            return repository.save(existingColeccionista);
        });
    }

    @Transactional
    @Override
    public Optional<Coleccionista> delete(Long id) {
        return repository.findById(id).map(coleccionista -> {
            repository.delete(coleccionista);
            return coleccionista;
        });
    }
}