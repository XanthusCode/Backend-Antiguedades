package com.example.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.dto.AuthResponse;
import com.example.domain.dto.LoginRequest;
import com.example.domain.dto.RegisterRequest;
import com.example.domain.repository.CuentaRepository;
import com.example.persistence.entities.Cuenta;
import com.example.security.jwt.JwtUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth") // Uso de minúsculas para consistencia
@RequiredArgsConstructor
public class AuthController {

    private final CuentaRepository repository;
    private final JwtUtils jwt;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        UserDetails user = repository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwt.getToken(user);
        return ResponseEntity.ok(AuthResponse.builder().token(token).build());
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        Cuenta tercero = Cuenta.builder()
                .id(registerRequest.getId())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                
                .build();

        repository.save(tercero);

        String token = jwt.getToken(tercero);
        return ResponseEntity.ok(AuthResponse.builder().token(token).build());
    }
}