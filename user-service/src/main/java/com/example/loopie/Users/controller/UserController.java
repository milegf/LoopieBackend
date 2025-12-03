package com.example.loopie.Users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.loopie.Users.model.User;
import com.example.loopie.Users.dto.UserResponseDTO;
import com.example.loopie.Users.model.User;
import com.example.loopie.Users.service.UserService;

import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor


public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return service.getAllUsers().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable int id) {
        return mapToDTO(service.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user) {
        return ResponseEntity.ok(mapToDTO(service.createUser(user)));
    }



    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok(mapToDTO(service.updateUser(id, user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    
    private UserResponseDTO mapToDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .rol(user.getRol())
                .direccion(user.getDireccion())
                .estado(user.isEnabled())
                .build();
    }
}
