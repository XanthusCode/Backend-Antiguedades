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

import com.example.domain.services.TipoTransaccion.TipoTransaccionService;
import com.example.persistence.entities.TipoTransaccion;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipo-transacciones")
public class TipoTransaccionController {

    @Autowired
    private TipoTransaccionService servicio;

    @GetMapping
    public List<TipoTransaccion> listarTipos() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTransaccion> ver(@PathVariable Long id) {
        Optional<TipoTransaccion> tipoTransaccionOpt = servicio.findById(id);
        return tipoTransaccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TipoTransaccion tipoTransaccion, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        TipoTransaccion nuevoTipo = servicio.save(tipoTransaccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody TipoTransaccion tipoTransaccion, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        Optional<TipoTransaccion> tipoTransaccionOpt = servicio.update(id, tipoTransaccion);
        return tipoTransaccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<TipoTransaccion> eliminar(@PathVariable Long id) {
        Optional<TipoTransaccion> tipoTransaccionOpt = servicio.delete(id);
        return tipoTransaccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
