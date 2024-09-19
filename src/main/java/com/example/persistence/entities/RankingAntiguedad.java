package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

// Clase de entidad
@Entity
@Table(name = "rankingAntiguedad")
public class RankingAntiguedad {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "rankingAntiguedad")
    private List<Antiguedad> antiguedades;

    // Constructor por defecto
    public RankingAntiguedad() {
    }

    // Constructor con parámetros
    public RankingAntiguedad(List<Antiguedad> antiguedades) {
        this.antiguedades = antiguedades;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Antiguedad> getAntiguedades() {
        return antiguedades;
    }

    public void setAntiguedades(List<Antiguedad> antiguedades) {
        this.antiguedades = antiguedades;
    }
}
