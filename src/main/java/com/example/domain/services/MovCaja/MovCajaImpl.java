package com.example.domain.services.MovCaja;


import com.example.persistence.entities.MovCaja;
import com.example.domain.repository.MovCajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovCajaImpl implements MovCajaService {

    private final MovCajaRepository repository;

    @Autowired
    public MovCajaImpl(MovCajaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MovCaja> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MovCaja> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public MovCaja save(MovCaja movCaja) {
        return repository.save(movCaja);
    }

    @Transactional
    @Override
    public Optional<MovCaja> update(Long id, MovCaja movCaja) {
        return repository.findById(id).map(existingMovCaja -> {
            //existingMovCaja.setMonto(movCaja.getMonto());
            //existingMovCaja.setFecha(movCaja.getFecha());
            //existingMovCaja.setTipo(movCaja.getTipo());
            return repository.save(existingMovCaja);
        });
    }

    @Transactional
    @Override
    public Optional<MovCaja> delete(Long id) {
        return repository.findById(id).map(movCaja -> {
            repository.delete(movCaja);
            return movCaja;
        });
    }
}