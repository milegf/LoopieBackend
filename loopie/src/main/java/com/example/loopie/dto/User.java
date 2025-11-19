package com.example.loopie.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String username;
    
    @Email(message = "Debe ser un correo válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    @NotBlank(message = "La confirmación de la contraseña no puede estar vacía")
    private String confirmPassword;

    @NotBlank(message = "El rol no puede estar vacío")
    private String role;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

}
