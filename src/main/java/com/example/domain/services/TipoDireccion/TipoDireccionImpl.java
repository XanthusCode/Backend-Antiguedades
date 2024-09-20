package com.example.domain.services.TipoDireccion;


import com.example.persistence.entities.TipoDireccion;
import com.example.domain.repository.TipoDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDireccionImpl implements TipoDireccionService {

    private final TipoDireccionRepository repository;

    @Autowired
    public TipoDireccionImpl(TipoDireccionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoDireccion> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoDireccion> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public TipoDireccion save(TipoDireccion tipoDireccion) {
        return repository.save(tipoDireccion);
    }

    @Transactional
    @Override
    public Optional<TipoDireccion> update(Long id, TipoDireccion tipoDireccion) {
        return repository.findById(id).map(existingTipoDireccion -> {
            //existingTipoDireccion.setNombre(tipoDireccion.getNombre());
            //existingTipoDireccion.setDescripcion(tipoDireccion.getDescripcion());
            return repository.save(existingTipoDireccion);
        });
    }

    @Transactional
    @Override
    public Optional<TipoDireccion> delete(Long id) {
        return repository.findById(id).map(tipoDireccion -> {
            repository.delete(tipoDireccion);
            return tipoDireccion;
        });
    }
}
