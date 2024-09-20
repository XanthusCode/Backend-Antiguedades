package com.example.domain.services.Sucursal;


import com.example.persistence.entities.Sucursal;
import com.example.domain.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalImpl implements SucursalService {

    private final SucursalRepository repository;

    @Autowired
    public SucursalImpl(SucursalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sucursal> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sucursal> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Sucursal save(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    @Transactional
    @Override
    public Optional<Sucursal> update(Long id, Sucursal sucursal) {
        return repository.findById(id).map(existingSucursal -> {
            //existingSucursal.setNombre(sucursal.getNombre());
            //existingSucursal.setDireccion(sucursal.getDireccion());
            //existingSucursal.setTelefono(sucursal.getTelefono());
            // Agrega otros campos según sea necesario
            return repository.save(existingSucursal);
        });
    }

    @Transactional
    @Override
    public Optional<Sucursal> delete(Long id) {
        return repository.findById(id).map(sucursal -> {
            repository.delete(sucursal);
            return sucursal;
        });
    }
}