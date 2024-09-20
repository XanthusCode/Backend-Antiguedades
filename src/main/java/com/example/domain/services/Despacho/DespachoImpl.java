package com.example.domain.services.Despacho;


import com.example.persistence.entities.Despacho;
import com.example.domain.repository.DespachoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DespachoImpl implements DespachoService {

    private final DespachoRepository repository;

    @Autowired
    public DespachoImpl(DespachoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Despacho> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Despacho> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Despacho save(Despacho despacho) {
        return repository.save(despacho);
    }

    @Transactional
    @Override
    public Optional<Despacho> update(Long id, Despacho despacho) {
        return repository.findById(id).map(existingDespacho -> {
            //existingDespacho.setNombre(despacho.getNombre());
            //existingDespacho.setDireccion(despacho.getDireccion());
            //existingDespacho.setTelefono(despacho.getTelefono());
            return repository.save(existingDespacho);
        });
    }

    @Transactional
    @Override
    public Optional<Despacho> delete(Long id) {
        return repository.findById(id).map(despacho -> {
            repository.delete(despacho);
            return despacho;
        });
    }
}
