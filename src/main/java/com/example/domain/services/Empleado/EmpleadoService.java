package com.example.domain.services.Empleado;


import com.example.persistence.entities.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> findAll();
    Optional<Empleado> findById(Long id);
    Empleado save(Empleado empleado);
    Optional<Empleado> update(Long id, Empleado empleado);
    Optional<Empleado> delete(Long id);
}
