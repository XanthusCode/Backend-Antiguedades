package com.example.domain.services.RankingAntiguedad;

import com.example.persistence.entities.RankingAntiguedad;
import com.example.domain.repository.RankingAntiguedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RankingAntiguedadImpl implements RankingAntiguedadService {

    private final RankingAntiguedadRepository repository;

    @Autowired
    public RankingAntiguedadImpl(RankingAntiguedadRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<RankingAntiguedad> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<RankingAntiguedad> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public RankingAntiguedad save(RankingAntiguedad rankingAntiguedad) {
        return repository.save(rankingAntiguedad);
    }

    @Transactional
    @Override
    public Optional<RankingAntiguedad> update(Long id, RankingAntiguedad rankingAntiguedad) {
        return repository.findById(id).map(existingRanking -> {
            //existingRanking.setNombre(rankingAntiguedad.getNombre());
            //existingRanking.setValor(rankingAntiguedad.getValor());
            return repository.save(existingRanking);
        });
    }

    @Transactional
    @Override
    public Optional<RankingAntiguedad> delete(Long id) {
        return repository.findById(id).map(rankingAntiguedad -> {
            repository.delete(rankingAntiguedad);
            return rankingAntiguedad;
        });
    }
}