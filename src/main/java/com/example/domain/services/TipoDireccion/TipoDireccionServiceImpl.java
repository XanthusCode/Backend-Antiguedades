package com.example.domain.services.TipoDireccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.persistence.entities.TipoDireccion;
import com.example.domain.repository.TipoDireccionRepository;

import com.example.domain.repository.SucursalRepository;

@Service
public class TipoDireccionServiceImpl implements TipoDireccionService {

    @Autowired
    private TipoDireccionRepository repository;

    @Override
    public List<TipoDireccion> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TipoDireccion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TipoDireccion save(TipoDireccion tipoDireccion) {
        return repository.save(tipoDireccion);
    }

    @Override
    public Optional<TipoDireccion> update(Long id, TipoDireccion tipoDireccion) {
        return repository.findById(id).map(existing -> {
            //existing.setNombre(tipoDireccion.getNombre()); // Ajusta según los campos
            return repository.save(existing);
        });
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
