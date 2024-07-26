package com.example.seguroautos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seguroautos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
