package com.example.domain.services.EpocaAntiguedad;


import com.example.persistence.entities.EpocaAntiguedad;
import com.example.domain.repository.EpocaAntiguedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EpocaAntiguedadImpl implements EpocaAntiguedadService {

    private final EpocaAntiguedadRepository repository;

    @Autowired
    public EpocaAntiguedadImpl(EpocaAntiguedadRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EpocaAntiguedad> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EpocaAntiguedad> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public EpocaAntiguedad save(EpocaAntiguedad epocaAntiguedad) {
        return repository.save(epocaAntiguedad);
    }

    @Transactional
    @Override
    public Optional<EpocaAntiguedad> update(Long id, EpocaAntiguedad epocaAntiguedad) {
        return repository.findById(id).map(existingEpoca -> {
            //existingEpoca.setNombre(epocaAntiguedad.getNombre());
            //existingEpoca.setDescripcion(epocaAntiguedad.getDescripcion());
            return repository.save(existingEpoca);
        });
    }

    @Transactional
    @Override
    public Optional<EpocaAntiguedad> delete(Long id) {
        return repository.findById(id).map(epocaAntiguedad -> {
            repository.delete(epocaAntiguedad);
            return epocaAntiguedad;
        });
    }
}