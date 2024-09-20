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

import com.example.domain.services.antiguedad.AntiguedadService;
import com.example.persistence.entities.Antiguedad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/antiguedades")
public class AntiguedadController {

    @Autowired
    private AntiguedadService servicio;

    @GetMapping
    public List<Antiguedad> listarAntiguedades() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Antiguedad> ver(@PathVariable Long id) {
        Optional<Antiguedad> antiguedadOpt = servicio.findById(id);
        if (antiguedadOpt.isPresent()) {
            return ResponseEntity.ok(antiguedadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Antiguedad antiguedad, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(antiguedad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Antiguedad antiguedad, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<Antiguedad> antiguedadOpt = servicio.update(id, antiguedad);
        if (antiguedadOpt.isPresent()) {
            return ResponseEntity.ok(antiguedadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Antiguedad> eliminar(@PathVariable Long id) {
        Optional<Antiguedad> antiguedadOpt = servicio.delete(id);
        if (antiguedadOpt.isPresent()) {
            return ResponseEntity.ok(antiguedadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
