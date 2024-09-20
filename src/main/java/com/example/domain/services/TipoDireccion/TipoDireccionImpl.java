package com.example.domain.services.TipoDireccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


import com.example.persistence.entities.TipoDireccion;
import com.example.domain.repository.TipoDireccionRepository;


@Service
public class TipoDireccionImpl implements TipoDireccionService {


    private TipoDireccionRepository repository;

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

    @Transactional(readOnly = true)
    @Override
    public TipoDireccion save(TipoDireccion tipoDireccion) {
        return repository.save(tipoDireccion);
    }

      @Transactional(readOnly = true)
    @Override
    public Optional<TipoDireccion> update(Long id, TipoDireccion tipoDireccion) {
        return repository.findById(id).map(existing -> {
            //existing.setNombre(tipoDireccion.getNombre()); // Ajusta según los campos
            return repository.save(existing);
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
