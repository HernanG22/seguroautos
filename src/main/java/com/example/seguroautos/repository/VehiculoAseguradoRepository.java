package com.example.seguroautos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seguroautos.model.VehiculoAsegurado;

public interface VehiculoAseguradoRepository extends JpaRepository<VehiculoAsegurado, Long> {
}
