package com.example.domain.services.TipoTransaccion;


import com.example.persistence.entities.TipoTransaccion;
import com.example.domain.repository.TipoTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTransaccionImpl implements TipoTransaccionService {

    private final TipoTransaccionRepository repository;

    @Autowired
    public TipoTransaccionImpl(TipoTransaccionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoTransaccion> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoTransaccion> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public TipoTransaccion save(TipoTransaccion tipoTransaccion) {
        return repository.save(tipoTransaccion);
    }

    @Transactional
    @Override
    public Optional<TipoTransaccion> update(Long id, TipoTransaccion tipoTransaccion) {
        return repository.findById(id).map(existingTipoTransaccion -> {
            //existingTipoTransaccion.setNombre(tipoTransaccion.getNombre());
            //existingTipoTransaccion.setDescripcion(tipoTransaccion.getDescripcion());
            return repository.save(existingTipoTransaccion);
        });
    }

    @Transactional
    @Override
    public Optional<TipoTransaccion> delete(Long id) {
        return repository.findById(id).map(tipoTransaccion -> {
            repository.delete(tipoTransaccion);
            return tipoTransaccion;
        });
    }
}