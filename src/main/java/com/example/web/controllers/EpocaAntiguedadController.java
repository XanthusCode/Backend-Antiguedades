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

import com.example.domain.services.EpocaAntiguedad.EpocaAntiguedadService;
import com.example.persistence.entities.EpocaAntiguedad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/epocas-antiguedad")
public class EpocaAntiguedadController {

    @Autowired
    private EpocaAntiguedadService servicio;

    @GetMapping
    public List<EpocaAntiguedad> listarEpocas() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpocaAntiguedad> ver(@PathVariable Long id) {
        Optional<EpocaAntiguedad> epocaOpt = servicio.findById(id);
        return epocaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody EpocaAntiguedad epocaAntiguedad, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(epocaAntiguedad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody EpocaAntiguedad epocaAntiguedad, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<EpocaAntiguedad> epocaOpt = servicio.update(id, epocaAntiguedad);
        return epocaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EpocaAntiguedad> eliminar(@PathVariable Long id) {
        Optional<EpocaAntiguedad> epocaOpt = servicio.delete(id);
        return epocaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
