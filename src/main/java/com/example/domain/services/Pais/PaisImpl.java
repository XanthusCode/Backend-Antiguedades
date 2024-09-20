package com.example.domain.services.Pais;


import com.example.persistence.entities.Pais;
import com.example.domain.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaisImpl implements PaisService {

    private final PaisRepository repository;

    @Autowired
    public PaisImpl(PaisRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pais> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pais> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Pais save(Pais pais) {
        return repository.save(pais);
    }

    @Transactional
    @Override
    public Optional<Pais> update(Long id, Pais pais) {
        return repository.findById(id).map(existingPais -> {
            //existingPais.setNombre(pais.getNombre());
            //existingPais.setCodigo(pais.getCodigo());
            return repository.save(existingPais);
        });
    }

    @Transactional
    @Override
    public Optional<Pais> delete(Long id) {
        return repository.findById(id).map(pais -> {
            repository.delete(pais);
            return pais;
        });
    }
}