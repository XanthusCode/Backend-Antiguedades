package com.example.domain.services.Empleado;


import com.example.persistence.entities.Empleado;
import com.example.domain.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoImpl implements EmpleadoService {

    private final EmpleadoRepository repository;

    @Autowired
    public EmpleadoImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Empleado> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empleado> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    @Transactional
    @Override
    public Optional<Empleado> update(Long id, Empleado empleado) {
        return repository.findById(id).map(existingEmpleado -> {
            //existingEmpleado.setNombre(empleado.getNombre());
            //existingEmpleado.setEmail(empleado.getEmail());
            //existingEmpleado.setTelefono(empleado.getTelefono());
            //existingEmpleado.setCargo(empleado.getCargo());
            return repository.save(existingEmpleado);
        });
    }

    @Transactional
    @Override
    public Optional<Empleado> delete(Long id) {
        return repository.findById(id).map(empleado -> {
            repository.delete(empleado);
            return empleado;
        });
    }
}