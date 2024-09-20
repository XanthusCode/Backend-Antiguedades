package com.example.domain.services.EpocaAntiguedad;

import com.example.persistence.entities.EpocaAntiguedad;
import java.util.List;
import java.util.Optional;

public interface EpocaAntiguedadService {
    List<EpocaAntiguedad> findAll();
    Optional<EpocaAntiguedad> findById(Long id);
    EpocaAntiguedad save(EpocaAntiguedad epocaAntiguedad);
    Optional<EpocaAntiguedad> update(Long id, EpocaAntiguedad epocaAntiguedad);
    Optional<EpocaAntiguedad> delete(Long id);
}
