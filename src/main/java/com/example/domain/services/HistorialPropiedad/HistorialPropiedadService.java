package com.example.domain.services.HistorialPropiedad;


import com.example.persistence.entities.HistorialPropiedad;
import java.util.List;
import java.util.Optional;

public interface HistorialPropiedadService {
    List<HistorialPropiedad> findAll();
    Optional<HistorialPropiedad> findById(Long id);
    HistorialPropiedad save(HistorialPropiedad historialPropiedad);
    Optional<HistorialPropiedad> update(Long id, HistorialPropiedad historialPropiedad);
    Optional<HistorialPropiedad> delete(Long id);
}
