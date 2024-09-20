package com.example.domain.services.Despacho;


import com.example.persistence.entities.Despacho;
import java.util.List;
import java.util.Optional;

public interface DespachoService {
    List<Despacho> findAll();
    Optional<Despacho> findById(Long id);
    Despacho save(Despacho despacho);
    Optional<Despacho> update(Long id, Despacho despacho);
    Optional<Despacho> delete(Long id);
}