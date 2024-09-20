package com.example.domain.services.EstacionPago;


import com.example.persistence.entities.EstacionPago;
import com.example.domain.repository.EstacionPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionPagoImpl implements EstacionPagoService {

    private final EstacionPagoRepository repository;

    @Autowired
    public EstacionPagoImpl(EstacionPagoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EstacionPago> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EstacionPago> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public EstacionPago save(EstacionPago estacionPago) {
        return repository.save(estacionPago);
    }

    @Transactional
    @Override
    public Optional<EstacionPago> update(Long id, EstacionPago estacionPago) {
        return repository.findById(id).map(existingEstacion -> {
            //existingEstacion.setNombre(estacionPago.getNombre());
            //existingEstacion.setDireccion(estacionPago.getDireccion());
            //existingEstacion.setTelefono(estacionPago.getTelefono());
            return repository.save(existingEstacion);
        });
    }

    @Transactional
    @Override
    public Optional<EstacionPago> delete(Long id) {
        return repository.findById(id).map(estacionPago -> {
            repository.delete(estacionPago);
            return estacionPago;
        });
    }
}