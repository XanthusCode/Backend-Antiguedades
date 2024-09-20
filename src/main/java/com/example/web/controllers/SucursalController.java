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
import com.example.domain.services.Sucursal.SucursalService;
import com.example.persistence.entities.Sucursal;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService servicio;

    @GetMapping
    public List<Sucursal> listarSucursales() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> ver(@PathVariable Long id) {
        Optional<Sucursal> sucursalOpt = servicio.findById(id);
        return sucursalOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Sucursal sucursal, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(sucursal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody Sucursal sucursal, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        Optional<Sucursal> sucursalOpt = servicio.update(id, sucursal);
        return sucursalOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sucursal> eliminar(@PathVariable Long id) {
        Optional<Sucursal> sucursalOpt = servicio.delete(id);
        return sucursalOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
