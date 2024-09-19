package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "categoria")
    private List<Antiguedad> antiguedades;

    public Categoria() {
    }

    public Categoria(List<Antiguedad> antiguedades) {
        this.antiguedades = antiguedades;
    }

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