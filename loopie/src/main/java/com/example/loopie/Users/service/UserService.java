package com.example.loopie.Users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.loopie.Users.dto.User;
import com.example.loopie.Users.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(int id, User user) {
        User dbUser = getUserById(id);
        dbUser.setNombre(user.getNombre());
        dbUser.setEmail(user.getEmail());
        return repository.save(dbUser);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public User saveUser(User u) {
        return repository.save(u);
    }
    
}
