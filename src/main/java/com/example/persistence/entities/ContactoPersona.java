package com.example.persistence.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "contactoPersonas")
public class ContactoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private ClaseContacto claseContacto;

    public ContactoPersona() {
    }

    public ContactoPersona(Persona persona, ClaseContacto claseContacto) {
        this.persona = persona;
        this.claseContacto = claseContacto;
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

    public ClaseContacto getClaseContacto() {
        return claseContacto;
    }

    public void setClaseContacto(ClaseContacto claseContacto) {
        this.claseContacto = claseContacto;
    }

   
}
