package com.example.domain.services.Region;


import com.example.persistence.entities.Region;
import java.util.List;
import java.util.Optional;

public interface RegionService {
    List<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region region);
    Optional<Region> update(Long id, Region region);
    Optional<Region> delete(Long id);
}