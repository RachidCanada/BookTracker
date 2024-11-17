package com.example.BookTracker.repository;

import com.example.BookTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Déclarez la méthode pour trouver un utilisateur par son nom d'utilisateur
    User findByUsername(String username);
}
