package com.example.seguroautos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seguroautos.model.app_User;

@Repository
public interface app_UserRepository extends JpaRepository<app_User, String> {

    // Método para encontrar un usuario por nombre de usuario
    app_User findByUsername(String username);
}


