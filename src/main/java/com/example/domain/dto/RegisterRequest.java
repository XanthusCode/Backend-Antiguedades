package com.example.domain.dto;



import com.example.persistence.entities.TipoPersona;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    Long id;
    String username;
    String password;
    TipoPersona role;
}
