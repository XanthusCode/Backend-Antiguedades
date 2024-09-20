package com.example.domain.services.Transaccion;


import com.example.persistence.entities.Transaccion;
import com.example.domain.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionImpl implements TransaccionService {

    private final TransaccionRepository repository;

    @Autowired
    public TransaccionImpl(TransaccionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Transaccion> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Transaccion> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Transaccion save(Transaccion transaccion) {
        return repository.save(transaccion);
    }

    @Transactional
    @Override
    public Optional<Transaccion> update(Long id, Transaccion transaccion) {
        return repository.findById(id).map(existingTransaccion -> {
            //existingTransaccion.setFecha(transaccion.getFecha());
            //existingTransaccion.setMonto(transaccion.getMonto());
            //existingTransaccion.setTipoTransaccion(transaccion.getTipoTransaccion());
            // Agrega otros campos según sea necesario
            return repository.save(existingTransaccion);
        });
    }

    @Transactional
    @Override
    public Optional<Transaccion> delete(Long id) {
        return repository.findById(id).map(transaccion -> {
            repository.delete(transaccion);
            return transaccion;
        });
    }
}