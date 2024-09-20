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
import com.example.domain.services.TipoMovCaja.TipoMovCajaService;
import com.example.persistence.entities.TipoMovCaja;

@RestController
@RequestMapping("/api/tipo-mov-caja")
public class TipoMovCajaController {

    @Autowired
    private TipoMovCajaService servicio;

    @GetMapping
    public List<TipoMovCaja> listarTipos() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMovCaja> ver(@PathVariable Long id) {
        Optional<TipoMovCaja> tipoMovCajaOpt = servicio.findById(id);
        return tipoMovCajaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TipoMovCaja tipoMovCaja, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        TipoMovCaja nuevoTipo = servicio.save(tipoMovCaja);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody TipoMovCaja tipoMovCaja, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        Optional<TipoMovCaja> tipoMovCajaOpt = servicio.update(id, tipoMovCaja);
        return tipoMovCajaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<TipoMovCaja> eliminar(@PathVariable Long id) {
        Optional<TipoMovCaja> tipoMovCajaOpt = servicio.delete(id);
        return tipoMovCajaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
