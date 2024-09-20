package com.example.domain.services.TransaccionMedioPago;


import com.example.persistence.entities.TransaccionMedioPago;
import com.example.domain.repository.TransaccionMedioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionMedioPagoImpl implements TransaccionMedioPagoService {

    private final TransaccionMedioPagoRepository repository;

    @Autowired
    public TransaccionMedioPagoImpl(TransaccionMedioPagoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransaccionMedioPago> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TransaccionMedioPago> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public TransaccionMedioPago save(TransaccionMedioPago transaccionMedioPago) {
        return repository.save(transaccionMedioPago);
    }

    @Transactional
    @Override
    public Optional<TransaccionMedioPago> update(Long id, TransaccionMedioPago transaccionMedioPago) {
        return repository.findById(id).map(existingTransaccionMedioPago -> {
            existingTransaccionMedioPago.setTransaccion(transaccionMedioPago.getTransaccion());
            existingTransaccionMedioPago.setMedioPago(transaccionMedioPago.getMedioPago());
            // Agrega otros campos según sea necesario
            return repository.save(existingTransaccionMedioPago);
        });
    }

    @Transactional
    @Override
    public Optional<TransaccionMedioPago> delete(Long id) {
        return repository.findById(id).map(transaccionMedioPago -> {
            repository.delete(transaccionMedioPago);
            return transaccionMedioPago;
        });
    }
}