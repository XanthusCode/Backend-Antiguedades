package com.example.domain.services.antiguedad;

import com.example.persistence.entities.*;
import com.example.domain.repository.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AntiguedadImpl implements AntiguedadService {

    @Autowired
    private AntiguedadRepository repository;

    @Transactional
    @Override
    public List<Antiguedad> findAll() {
        return (List<Antiguedad>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Antiguedad> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Antiguedad save(Antiguedad antiguedad) {
        return repository.save(antiguedad);
    }

    @Transactional
    @Override
    public Optional<Antiguedad> update(Long id, Antiguedad antiguedad) {
        Optional<Antiguedad> antiguedadOpt = repository.findById(id);
        if (antiguedadOpt.isPresent()) {
            Antiguedad antiguedadItem = antiguedadOpt.orElseThrow();
            antiguedadItem.setCategoria(antiguedad.getCategoria());
            antiguedadItem.setEpocaAntiguedad(antiguedad.getEpocaAntiguedad());
            antiguedadItem.setGaleria(antiguedad.getGaleria());
            antiguedadItem.setRankingAntiguedad(antiguedad.getRankingAntiguedad());
            return Optional.of(repository.save(antiguedadItem));
        }
        return antiguedadOpt;
    }

    @Transactional
    @Override
    public Optional<Antiguedad> delete(Long id) {
        Optional<Antiguedad> antiguedadOpt = repository.findById(id);
        antiguedadOpt.ifPresent(antiguedadItem -> {
            repository.delete(antiguedadItem);
        });
        return antiguedadOpt;
    }
}
