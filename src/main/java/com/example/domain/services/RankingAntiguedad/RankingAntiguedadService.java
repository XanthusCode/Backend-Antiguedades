package com.example.domain.services.RankingAntiguedad;

import com.example.persistence.entities.RankingAntiguedad;
import java.util.List;
import java.util.Optional;

public interface RankingAntiguedadService {
    List<RankingAntiguedad> findAll();
    Optional<RankingAntiguedad> findById(Long id);
    RankingAntiguedad save(RankingAntiguedad rankingAntiguedad);
    Optional<RankingAntiguedad> update(Long id, RankingAntiguedad rankingAntiguedad);
    Optional<RankingAntiguedad> delete(Long id);
}