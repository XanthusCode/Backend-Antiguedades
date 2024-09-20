package com.example.domain.services.Empresa;

import com.example.persistence.entities.Empresa;
import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> findAll();
    Optional<Empresa> findById(Long id);
    Empresa save(Empresa empresa);
    Optional<Empresa> update(Long id, Empresa empresa);
    Optional<Empresa> delete(Long id);
}