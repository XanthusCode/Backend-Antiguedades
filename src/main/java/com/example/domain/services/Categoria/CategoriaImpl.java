package com.example.domain.services.Categoria;


import com.example.persistence.entities.Categoria;
import com.example.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Autowired
    public CategoriaImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Transactional
    @Override
    public Optional<Categoria> update(Long id, Categoria categoria) {
        return repository.findById(id).map(existingCategoria -> {
            //existingCategoria.setNombre(categoria.getNombre());
            //existingCategoria.setDescripcion(categoria.getDescripcion());
            return repository.save(existingCategoria);
        });
    }

    @Transactional
    @Override
    public Optional<Categoria> delete(Long id) {
        return repository.findById(id).map(categoria -> {
            repository.delete(categoria);
            return categoria;
        });
    }
}
