package com.example.domain.services.MovCaja;


import com.example.persistence.entities.MovCaja;
import java.util.List;
import java.util.Optional;

public interface MovCajaService {
    List<MovCaja> findAll();
    Optional<MovCaja> findById(Long id);
    MovCaja save(MovCaja movCaja);
    Optional<MovCaja> update(Long id, MovCaja movCaja);
    Optional<MovCaja> delete(Long id);
}