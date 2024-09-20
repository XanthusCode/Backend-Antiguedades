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

import com.example.domain.services.HistorialPropiedad.HistorialPropiedadService;
import com.example.persistence.entities.HistorialPropiedad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historial-propiedades")
public class HistorialPropiedadController {

    @Autowired
    private HistorialPropiedadService servicio;

    @GetMapping
    public List<HistorialPropiedad> listarHistorial() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialPropiedad> ver(@PathVariable Long id) {
        Optional<HistorialPropiedad> historialOpt = servicio.findById(id);
        return historialOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody HistorialPropiedad historialPropiedad, BindingResult resultado) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(historialPropiedad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody HistorialPropiedad historialPropiedad, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasFieldErrors()) {
            return validar(resultado);
        }
        Optional<HistorialPropiedad> historialOpt = servicio.update(id, historialPropiedad);
        return historialOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HistorialPropiedad> eliminar(@PathVariable Long id) {
        Optional<HistorialPropiedad> historialOpt = servicio.delete(id);
        return historialOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
