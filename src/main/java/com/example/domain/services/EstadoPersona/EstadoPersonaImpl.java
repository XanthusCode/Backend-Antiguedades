package com.example.domain.services.EstadoPersona;


import com.example.persistence.entities.EstadoPersona;
import com.example.domain.repository.EstadoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPersonaImpl implements EstadoPersonaService {

    private final EstadoPersonaRepository repository;

    @Autowired
    public EstadoPersonaImpl(EstadoPersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EstadoPersona> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EstadoPersona> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public EstadoPersona save(EstadoPersona estadoPersona) {
        return repository.save(estadoPersona);
    }

    @Transactional
    @Override
    public Optional<EstadoPersona> update(Long id, EstadoPersona estadoPersona) {
        return repository.findById(id).map(existingEstado -> {
            //existingEstado.setNombre(estadoPersona.getNombre());
            //existingEstado.setDescripcion(estadoPersona.getDescripcion());
            return repository.save(existingEstado);
        });
    }

    @Transactional
    @Override
    public Optional<EstadoPersona> delete(Long id) {
        return repository.findById(id).map(estadoPersona -> {
            repository.delete(estadoPersona);
            return estadoPersona;
        });
    }
}