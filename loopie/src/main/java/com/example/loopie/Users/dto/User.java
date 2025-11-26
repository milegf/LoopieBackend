package com.example.loopie.Users.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String username;
    
    @Column(name = "email")
    @Email(message = "Debe ser un correo válido")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Column(name = "rol")
    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;

    @Column(name = "direccion")
    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @Column(name = "estado")
    private String estado;


}
