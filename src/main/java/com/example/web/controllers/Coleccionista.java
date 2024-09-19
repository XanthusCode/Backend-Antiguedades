package com.example.persistence.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "coleccionistas")
public class Coleccionista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Persona persona;

    private String areaEspecializacion;
    private Integer añosExperiencia;
    
    public Coleccionista() {
    }
    public Coleccionista(Persona persona, String areaEspecializacion, Integer añosExperiencia) {
        this.persona = persona;
        this.areaEspecializacion = areaEspecializacion;
        this.añosExperiencia = añosExperiencia;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getAreaEspecializacion() {
        return areaEspecializacion;
    }
    public void setAreaEspecializacion(String areaEspecializacion) {
        this.areaEspecializacion = areaEspecializacion;
    }
    public Integer getAñosExperiencia() {
        return añosExperiencia;
    }
    public void setAñosExperiencia(Integer añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    
}