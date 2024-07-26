package com.example.seguroautos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seguroautos.model.Productor;

public interface ProductorRepository extends JpaRepository<Productor, Long> {
}

