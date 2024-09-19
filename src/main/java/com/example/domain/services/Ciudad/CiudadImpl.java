package com.example.domain.services.Ciudad;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.repository.*;
import com.example.persistence.entities.Ciudad;

@Service
public class CiudadImpl implements CiudadService{

   @Autowired
    private CiudadRepository repository;

    @Transactional
    @Override
    public List<Ciudad> findAll() {
        return(List<Ciudad>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Ciudad> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Ciudad save(Ciudad Ciudad) {
        return repository.save(Ciudad);
    }

    @Transactional
    @Override
    public Optional<Ciudad> update(Long id, Ciudad ciudad) {
       Optional<Ciudad> ciudadOpt = repository.findById(id);
       if(ciudadOpt.isPresent()){
            Ciudad ciudadItem = ciudadOpt.orElseThrow();
            ciudadItem.setPersonas(ciudad.getPersonas());
            ciudadItem.setRegion(ciudad.getRegion());
            return Optional.of(repository.save(ciudadItem));
       }
       return ciudadOpt;
    }

    @Transactional
    @Override
    public Optional<Ciudad> delete(Long id) {
        Optional<Ciudad> CiudadOpt = repository.findById(id);
        CiudadOpt.ifPresent(CiudadItem ->{
            repository.delete(CiudadItem);
        });
        return CiudadOpt;
    }

}
