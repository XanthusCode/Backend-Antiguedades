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
import com.example.domain.services.TransaccionMedioPago.TransaccionMedioPagoService;
import com.example.persistence.entities.TransaccionMedioPago;

@RestController
@RequestMapping("/api/transaccion-medios-pago")
public class TransaccionMedioPagoController {

    @Autowired
    private TransaccionMedioPagoService servicio;

    @GetMapping
    public List<TransaccionMedioPago> listarMediosPago() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionMedioPago> ver(@PathVariable Long id) {
        Optional<TransaccionMedioPago> medioPagoOpt = servicio.findById(id);
        return medioPagoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TransaccionMedioPago medioPago, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        TransaccionMedioPago nuevoMedioPago = servicio.save(medioPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedioPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody TransaccionMedioPago medioPago, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return validar(resultado);
        }
        Optional<TransaccionMedioPago> medioPagoOpt = servicio.update(id, medioPago);
        return medioPagoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<TransaccionMedioPago> eliminar(@PathVariable Long id) {
        Optional<TransaccionMedioPago> medioPagoOpt = servicio.delete(id);
        return medioPagoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validar(BindingResult resultado) {
        Map<String, String> errores = new HashMap<>();
        resultado.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
