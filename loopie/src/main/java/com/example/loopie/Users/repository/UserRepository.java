package com.example.loopie.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loopie.Users.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
