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

import com.example.domain.services.DireccionPersona.DireccionPersonaService;
import com.example.persistence.entities.DireccionPersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/direccion-persona")
public class DireccionPersonaController {

    @Autowired
    private DireccionPersonaService servicio;

    @GetMapping
    public List<DireccionPersona> listarDirecciones() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionPersona> ver(@PathVariable Long id) {
        Optional<DireccionPersona> direccionOpt = servicio.findById(id);
        return direccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody DireccionPersona direccionPersona, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(direccionPersona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody DireccionPersona direccionPersona, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<DireccionPersona> direccionOpt = servicio.update(id, direccionPersona);
        return direccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DireccionPersona> eliminar(@PathVariable Long id) {
        Optional<DireccionPersona> direccionOpt = servicio.delete(id);
        return direccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
