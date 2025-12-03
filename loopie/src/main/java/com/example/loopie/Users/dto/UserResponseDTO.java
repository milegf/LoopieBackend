package com.example.loopie.Users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private int id;
    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private String rol;
    private String direccion;
    private boolean estado;
}
