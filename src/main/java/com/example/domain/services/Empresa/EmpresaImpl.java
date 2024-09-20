package com.example.domain.services.Empresa;



import com.example.persistence.entities.Empresa;
import com.example.domain.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaImpl implements EmpresaService {

    private final EmpresaRepository repository;

    @Autowired
    public EmpresaImpl(EmpresaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Empresa> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empresa> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    @Transactional
    @Override
    public Optional<Empresa> update(Long id, Empresa empresa) {
        return repository.findById(id).map(existingEmpresa -> {
            //existingEmpresa.setNombre(empresa.getNombre());
            //existingEmpresa.setDireccion(empresa.getDireccion());
            //existingEmpresa.setTelefono(empresa.getTelefono());
            //existingEmpresa.setEmail(empresa.getEmail());
            return repository.save(existingEmpresa);
        });
    }

    @Transactional
    @Override
    public Optional<Empresa> delete(Long id) {
        return repository.findById(id).map(empresa -> {
            repository.delete(empresa);
            return empresa;
        });
    }
}