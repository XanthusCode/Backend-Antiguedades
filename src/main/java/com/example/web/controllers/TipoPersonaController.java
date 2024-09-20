package com.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.validation.Valid;
import com.example.domain.services.TipoPersona.TipoPersonaService;
import com.example.persistence.entities.TipoPersona;

@RestController
@RequestMapping("/api/tipo-personas")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaService servicio;

    @GetMapping
    public List<TipoPersona> listarTipos() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> ver(@PathVariable Long id) {
        Optional<TipoPersona> tipoPersonaOpt = servicio.findById(id);
        return tipoPersonaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TipoPersona tipoPersona, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        TipoPersona nuevoTipo = servicio.save(tipoPersona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody TipoPersona tipoPersona, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        Optional<TipoPersona> tipoPersonaOpt = servicio.update(id, tipoPersona);
        return tipoPersonaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<TipoPersona> eliminar(@PathVariable Long id) {
        Optional<TipoPersona> tipoPersonaOpt = servicio.delete(id);
        return tipoPersonaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
