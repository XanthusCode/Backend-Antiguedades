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
import com.example.domain.services.Transaccion.TransaccionService;
import com.example.persistence.entities.Transaccion;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService servicio;

    @GetMapping
    public List<Transaccion> listarTransacciones() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> ver(@PathVariable Long id) {
        Optional<Transaccion> transaccionOpt = servicio.findById(id);
        return transaccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Transaccion transaccion, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(transaccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Transaccion transaccion, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        Optional<Transaccion> transaccionOpt = servicio.update(id, transaccion);
        return transaccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaccion> eliminar(@PathVariable Long id) {
        Optional<Transaccion> transaccionOpt = servicio.delete(id);
        return transaccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
