package com.example.domain.services.TipoMovCaja;


import com.example.persistence.entities.TipoMovCaja;
import com.example.domain.repository.TipoMovCajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoMovCajaImpl implements TipoMovCajaService {

    private final TipoMovCajaRepository repository;

    @Autowired
    public TipoMovCajaImpl(TipoMovCajaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoMovCaja> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoMovCaja> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public TipoMovCaja save(TipoMovCaja tipoMovCaja) {
        return repository.save(tipoMovCaja);
    }

    @Transactional
    @Override
    public Optional<TipoMovCaja> update(Long id, TipoMovCaja tipoMovCaja) {
        return repository.findById(id).map(existingTipoMovCaja -> {
            //existingTipoMovCaja.setNombre(tipoMovCaja.getNombre());
            //existingTipoMovCaja.setDescripcion(tipoMovCaja.getDescripcion());
            return repository.save(existingTipoMovCaja);
        });
    }

    @Transactional
    @Override
    public Optional<TipoMovCaja> delete(Long id) {
        return repository.findById(id).map(tipoMovCaja -> {
            repository.delete(tipoMovCaja);
            return tipoMovCaja;
        });
    }
}