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

import com.example.domain.services.Ciudad.CiudadService;
import com.example.persistence.entities.Ciudad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    @Autowired
    private CiudadService servicio;

    @GetMapping
    public List<Ciudad> listarCiudades() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> ver(@PathVariable Long id) {
        Optional<Ciudad> ciudadOpt = servicio.findById(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Ciudad ciudad, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(ciudad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Ciudad ciudad, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<Ciudad> ciudadOpt = servicio.update(id, ciudad);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());  // Normalmente se usa 200 OK para actualizaciones
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ciudad> eliminar(@PathVariable Long id) {
        Optional<Ciudad> ciudadOpt = servicio.delete(id);
        if (ciudadOpt.isPresent()) {
            return ResponseEntity.ok(ciudadOpt.orElseThrow());
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