package com.example.domain.services.ClaseContacto;


import com.example.persistence.entities.ClaseContacto;
import com.example.domain.repository.ClaseContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseContactoImpl implements ClaseContactoService {

    private final ClaseContactoRepository repository;

    @Autowired
    public ClaseContactoImpl(ClaseContactoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClaseContacto> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ClaseContacto> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ClaseContacto save(ClaseContacto claseContacto) {
        return repository.save(claseContacto);
    }

    @Transactional
    @Override
    public Optional<ClaseContacto> update(Long id, ClaseContacto claseContacto) {
        return repository.findById(id).map(existingClaseContacto -> {
            //existingClaseContacto.setNombre(claseContacto.getNombre());
            //existingClaseContacto.setEmail(claseContacto.getEmail());
            //existingClaseContacto.setTelefono(claseContacto.getTelefono());
            return repository.save(existingClaseContacto);
        });
    }

    @Transactional
    @Override
    public Optional<ClaseContacto> delete(Long id) {
        return repository.findById(id).map(claseContacto -> {
            repository.delete(claseContacto);
            return claseContacto;
        });
    }
}