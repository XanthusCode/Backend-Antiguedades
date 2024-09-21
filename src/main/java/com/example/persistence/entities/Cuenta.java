package com.example.persistence.entities;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cuentas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cuenta implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER) 
    @JoinColumn(name = "cuenta_id") 
    private Set<Persona> roles;

    @Enumerated(EnumType.STRING)
    private TipoPersona tipoPersona;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
            .map(persona -> new SimpleGrantedAuthority(persona.getTipoPersona().toString())) // Cambia según la estructura de Persona
            .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
