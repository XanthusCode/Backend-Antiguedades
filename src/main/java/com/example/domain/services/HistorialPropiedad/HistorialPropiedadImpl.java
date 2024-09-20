package com.example.domain.services.HistorialPropiedad;

import com.example.persistence.entities.HistorialPropiedad;
import com.example.domain.repository.HistorialPropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialPropiedadImpl implements HistorialPropiedadService {

    private final HistorialPropiedadRepository repository;

    @Autowired
    public HistorialPropiedadImpl(HistorialPropiedadRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<HistorialPropiedad> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<HistorialPropiedad> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public HistorialPropiedad save(HistorialPropiedad historialPropiedad) {
        return repository.save(historialPropiedad);
    }

    @Transactional
    @Override
    public Optional<HistorialPropiedad> update(Long id, HistorialPropiedad historialPropiedad) {
        return repository.findById(id).map(existingHistorial -> {
            //existingHistorial.setFecha(historialPropiedad.getFecha());
            //existingHistorial.setDescripcion(historialPropiedad.getDescripcion());
            //existingHistorial.setPropiedad(historialPropiedad.getPropiedad());
            return repository.save(existingHistorial);
        });
    }

    @Transactional
    @Override
    public Optional<HistorialPropiedad> delete(Long id) {
        return repository.findById(id).map(historialPropiedad -> {
            repository.delete(historialPropiedad);
            return historialPropiedad;
        });
    }
}