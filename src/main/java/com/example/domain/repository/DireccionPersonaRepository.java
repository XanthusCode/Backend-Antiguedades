package com.example.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.persistence.entities.*;

@Repository
public interface DireccionPersonaRepository extends JpaRepository<DireccionPersona, Long> {
}