package com.example.web.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import com.example.domain.services.TipoDireccion.TipoDireccionService;

// import com.example.persistence.entities.TipoDireccion;

// import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipo-direcciones")
public class TipoDireccionController {

    // @Autowired
    // private TipoDireccionService servicio;

    // @GetMapping
    // public List<TipoDireccion> listarTipos() {
    //     return servicio.findAll();
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<TipoDireccion> ver(@PathVariable Long id) {
    //     Optional<TipoDireccion> tipoDireccionOpt = servicio.findById(id);
    //     return tipoDireccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // @PostMapping
    // public ResponseEntity<?> crear(@Valid @RequestBody TipoDireccion tipoDireccion, BindingResult resultado) {
    //     if (resultado.hasErrors()) {
    //         return validar(resultado);
    //     }
    //     TipoDireccion nuevoTipo = servicio.save(tipoDireccion);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> actualizar(@Valid @RequestBody TipoDireccion tipoDireccion, BindingResult resultado, @PathVariable Long id) {
    //     if (resultado.hasErrors()) {
    //         return validar(resultado);
    //     }
    //     Optional<TipoDireccion> tipoDireccionOpt = servicio.update(id, tipoDireccion);
    //     return tipoDireccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    //  @DeleteMapping("/{id}")
    // public ResponseEntity<TipoDireccion> eliminar(@PathVariable Long id) {
    //     Optional<TipoDireccion> TipoDireccion = servicio.delete(id);
    //     return TipoDireccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // private ResponseEntity<?> validar(BindingResult resultado) {
    //     Map<String, String> errores = new HashMap<>();
    //     resultado.getFieldErrors().forEach(err -> {
    //         errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
    //     });
    //     return ResponseEntity.badRequest().body(errores);
    // }
}
