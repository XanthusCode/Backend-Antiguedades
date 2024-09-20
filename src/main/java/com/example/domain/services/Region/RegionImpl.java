package com.example.domain.services.Region;


import com.example.persistence.entities.Region;
import com.example.domain.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RegionImpl implements RegionService {

    private final RegionRepository repository;

    @Autowired
    public RegionImpl(RegionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Region> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Region> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Transactional
    @Override
    public Optional<Region> update(Long id, Region region) {
        return repository.findById(id).map(existingRegion -> {
            //existingRegion.setNombre(region.getNombre());
            //existingRegion.setDescripcion(region.getDescripcion());
            return repository.save(existingRegion);
        });
    }

    @Transactional
    @Override
    public Optional<Region> delete(Long id) {
        return repository.findById(id).map(region -> {
            repository.delete(region);
            return region;
        });
    }
}