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

import com.example.domain.services.Coleccionista.ColeccionistaService;
import com.example.persistence.entities.Coleccionista;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/coleccionistas")
public class ColeccionistaController {

    @Autowired
    private ColeccionistaService servicio;

    @GetMapping
    public List<Coleccionista> listarColeccionistas() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleccionista> ver(@PathVariable Long id) {
        Optional<Coleccionista> coleccionistaOpt = servicio.findById(id);
        return coleccionistaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Coleccionista coleccionista, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(coleccionista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Coleccionista coleccionista, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<Coleccionista> coleccionistaOpt = servicio.update(id, coleccionista);
        return coleccionistaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coleccionista> eliminar(@PathVariable Long id) {
        Optional<Coleccionista> coleccionistaOpt = servicio.delete(id);
        return coleccionistaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
