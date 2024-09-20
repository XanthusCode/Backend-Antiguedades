package com.example.domain.services.DetalleTransaccion;


import com.example.persistence.entities.DetalleTransaccion;
import com.example.domain.repository.DetalleTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleTransaccionImpl implements DetalleTransaccionService {

    private final DetalleTransaccionRepository repository;

    @Autowired
    public DetalleTransaccionImpl(DetalleTransaccionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DetalleTransaccion> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DetalleTransaccion> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DetalleTransaccion save(DetalleTransaccion detalleTransaccion) {
        return repository.save(detalleTransaccion);
    }

    @Transactional
    @Override
    public Optional<DetalleTransaccion> update(Long id, DetalleTransaccion detalleTransaccion) {
        return repository.findById(id).map(existingDetalle -> {
            //existingDetalle.setCantidad(detalleTransaccion.getCantidad());
            //existingDetalle.setPrecio(detalleTransaccion.getPrecio());
            //existingDetalle.setTransaccion(detalleTransaccion.getTransaccion());
            return repository.save(existingDetalle);
        });
    }

    @Transactional
    @Override
    public Optional<DetalleTransaccion> delete(Long id) {
        return repository.findById(id).map(detalleTransaccion -> {
            repository.delete(detalleTransaccion);
            return detalleTransaccion;
        });
    }
}
