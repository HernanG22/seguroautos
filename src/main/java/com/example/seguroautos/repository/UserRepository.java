package com.example.seguroautos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seguroautos.model.app_User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<app_User, String> {

    // Método para encontrar un usuario por nombre de usuario
    Optional<app_User> findByUsername(String username);
}


