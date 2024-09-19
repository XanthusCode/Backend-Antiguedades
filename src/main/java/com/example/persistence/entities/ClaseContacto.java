package com.example.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "claseContacto")
public class ClaseContacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "claseContacto")
    private List<ContactoPersona> contactos;

    public ClaseContacto() {
    }

    public ClaseContacto(List<ContactoPersona> contactos) {
        this.contactos = contactos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ContactoPersona> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoPersona> contactos) {
        this.contactos = contactos;
    }

    
}