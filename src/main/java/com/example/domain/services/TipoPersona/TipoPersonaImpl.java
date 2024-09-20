package com.example.domain.services.TipoPersona;


import com.example.persistence.entities.TipoPersona;
import com.example.domain.repository.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPersonaImpl implements TipoPersonaService {

    private final TipoPersonaRepository repository;

    @Autowired
    public TipoPersonaImpl(TipoPersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoPersona> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoPersona> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public TipoPersona save(TipoPersona tipoPersona) {
        return repository.save(tipoPersona);
    }

    @Transactional
    @Override
    public Optional<TipoPersona> update(Long id, TipoPersona tipoPersona) {
        return repository.findById(id).map(existingTipoPersona -> {
            //existingTipoPersona.setNombre(tipoPersona.getNombre());
            //existingTipoPersona.setDescripcion(tipoPersona.getDescripcion());
            return repository.save(existingTipoPersona);
        });
    }

    @Transactional
    @Override
    public Optional<TipoPersona> delete(Long id) {
        return repository.findById(id).map(tipoPersona -> {
            repository.delete(tipoPersona);
            return tipoPersona;
        });
    }
}