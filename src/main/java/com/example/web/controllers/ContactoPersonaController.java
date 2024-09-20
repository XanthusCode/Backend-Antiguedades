package com.example.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.services.ContactoPersona.ContactoPersonaService;
import com.example.persistence.entities.ContactoPersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contacto-persona")
public class ContactoPersonaController {

    @Autowired
    private ContactoPersonaService servicio;

    @GetMapping
    public List<ContactoPersona> listarContactos() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoPersona> ver(@PathVariable Long id) {
        Optional<ContactoPersona> contactoOpt = servicio.findById(id);
        return contactoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody ContactoPersona contactoPersona, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(contactoPersona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody ContactoPersona contactoPersona, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<ContactoPersona> contactoOpt = servicio.update(id, contactoPersona);
        return contactoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContactoPersona> eliminar(@PathVariable Long id) {
        Optional<ContactoPersona> contactoOpt = servicio.delete(id);
        return contactoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
