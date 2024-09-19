package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "antiguedad")
public class Antiguedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "galeria_id")
    private Galeria galeria;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private EpocaAntiguedad epocaAntiguedad;

    @ManyToOne
    private RankingAntiguedad rankingAntiguedad;

    public Antiguedad() {
    }

    public Antiguedad(Galeria galeria, Categoria categoria, EpocaAntiguedad epocaAntiguedad,
            RankingAntiguedad rankingAntiguedad) {
        this.galeria = galeria;
        this.categoria = categoria;
        this.epocaAntiguedad = epocaAntiguedad;
        this.rankingAntiguedad = rankingAntiguedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EpocaAntiguedad getEpocaAntiguedad() {
        return epocaAntiguedad;
    }

    public void setEpocaAntiguedad(EpocaAntiguedad epocaAntiguedad) {
        this.epocaAntiguedad = epocaAntiguedad;
    }

    public RankingAntiguedad getRankingAntiguedad() {
        return rankingAntiguedad;
    }

    public void setRankingAntiguedad(RankingAntiguedad rankingAntiguedad) {
        this.rankingAntiguedad = rankingAntiguedad;
    }

    
}