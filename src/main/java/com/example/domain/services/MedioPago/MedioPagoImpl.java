package com.example.domain.services.MedioPago;


import com.example.persistence.entities.MedioPago;
import com.example.domain.repository.MedioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedioPagoImpl implements MedioPagoService {

    private final MedioPagoRepository repository;

    @Autowired
    public MedioPagoImpl(MedioPagoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MedioPago> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MedioPago> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public MedioPago save(MedioPago medioPago) {
        return repository.save(medioPago);
    }

    @Transactional
    @Override
    public Optional<MedioPago> update(Long id, MedioPago medioPago) {
        return repository.findById(id).map(existingMedioPago -> {
            //existingMedioPago.setNombre(medioPago.getNombre());
            //existingMedioPago.setDescripcion(medioPago.getDescripcion());
            return repository.save(existingMedioPago);
        });
    }

    @Transactional
    @Override
    public Optional<MedioPago> delete(Long id) {
        return repository.findById(id).map(medioPago -> {
            repository.delete(medioPago);
            return medioPago;
        });
    }
}