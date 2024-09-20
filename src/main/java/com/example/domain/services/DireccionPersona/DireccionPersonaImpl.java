package com.example.domain.services.DireccionPersona;


import com.example.persistence.entities.DireccionPersona;
import com.example.domain.repository.DireccionPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionPersonaImpl implements DireccionPersonaService {

    private final DireccionPersonaRepository repository;

    @Autowired
    public DireccionPersonaImpl(DireccionPersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DireccionPersona> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DireccionPersona> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DireccionPersona save(DireccionPersona direccionPersona) {
        return repository.save(direccionPersona);
    }

    @Transactional
    @Override
    public Optional<DireccionPersona> update(Long id, DireccionPersona direccionPersona) {
        return repository.findById(id).map(existingDireccion -> {
            //existingDireccion.setCalle(direccionPersona.getCalle());
            //existingDireccion.setCiudad(direccionPersona.getCiudad());
            //existingDireccion.setCodigoPostal(direccionPersona.getCodigoPostal());
            return repository.save(existingDireccion);
        });
    }

    @Transactional
    @Override
    public Optional<DireccionPersona> delete(Long id) {
        return repository.findById(id).map(direccionPersona -> {
            repository.delete(direccionPersona);
            return direccionPersona;
        });
    }
}
