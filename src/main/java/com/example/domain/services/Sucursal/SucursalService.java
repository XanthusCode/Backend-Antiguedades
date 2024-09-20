package com.example.domain.services.Sucursal;

import com.example.persistence.entities.Sucursal;
import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<Sucursal> findAll();
    Optional<Sucursal> findById(Long id);
    Sucursal save(Sucursal sucursal);
    Optional<Sucursal> update(Long id, Sucursal sucursal);
    Optional<Sucursal> delete(Long id);
}