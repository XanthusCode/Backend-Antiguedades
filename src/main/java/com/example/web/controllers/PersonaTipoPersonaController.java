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

import com.example.domain.services.PersonaTipoPersona.PersonaTipoPersonaService;
import com.example.persistence.entities.PersonaTipoPersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipo-personas")
public class PersonaTipoPersonaController {

    @Autowired
    private PersonaTipoPersonaService servicio;

    @GetMapping
    public List<PersonaTipoPersona> listarTipos() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaTipoPersona> ver(@PathVariable Long id) {
        Optional<PersonaTipoPersona> tipoOpt = servicio.findById(id);
        return tipoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody PersonaTipoPersona tipo, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(tipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody PersonaTipoPersona tipo, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<PersonaTipoPersona> tipoOpt = servicio.update(id, tipo);
        return tipoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaTipoPersona> eliminar(@PathVariable Long id) {
        Optional<PersonaTipoPersona> tipoOpt = servicio.delete(id);
        return tipoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
