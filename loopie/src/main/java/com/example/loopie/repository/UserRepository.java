package com.example.loopie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loopie.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
