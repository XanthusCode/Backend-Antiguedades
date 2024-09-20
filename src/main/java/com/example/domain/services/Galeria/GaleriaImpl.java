package com.example.domain.services.Galeria;


import com.example.persistence.entities.Galeria;
import com.example.domain.repository.GaleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GaleriaImpl implements GaleriaService {

    private final GaleriaRepository repository;

    @Autowired
    public GaleriaImpl(GaleriaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Galeria> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Galeria> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Galeria save(Galeria galeria) {
        return repository.save(galeria);
    }

    @Transactional
    @Override
    public Optional<Galeria> update(Long id, Galeria galeria) {
        return repository.findById(id).map(existingGaleria -> {
            //existingGaleria.setNombre(galeria.getNombre());
            //existingGaleria.setDescripcion(galeria.getDescripcion());
            return repository.save(existingGaleria);
        });
    }

    @Transactional
    @Override
    public Optional<Galeria> delete(Long id) {
        return repository.findById(id).map(galeria -> {
            repository.delete(galeria);
            return galeria;
        });
    }
}