package com.example.seguroautos.controller;

import com.example.seguroautos.model.Productor;
import com.example.seguroautos.repository.ProductorRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productores")
public class ProductorController {

    @Autowired
    private ProductorRepository productorRepository;
    
    @Operation(summary = "Obtener productores", description = "Obtiene un listado de todos los productores.")
    @GetMapping
    public List<Productor> getAllProductores() {
        return productorRepository.findAll();
    }

    @PostMapping
    public Productor createProductor(@RequestBody Productor productor) {
        return productorRepository.save(productor);
    }

    @GetMapping("/{id}")
    public Productor getProductorById(@PathVariable Long id) {
        return productorRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Productor updateProductor(@PathVariable Long id, @RequestBody Productor productorDetails) {
        Productor productor = productorRepository.findById(id).orElseThrow();
        productor.setNombre(productorDetails.getNombre());
        productor.setApellido(productorDetails.getApellido());
        productor.setEmail(productorDetails.getEmail());
        return productorRepository.save(productor);
    }

    @DeleteMapping("/{id}")
    public void deleteProductor(@PathVariable Long id) {
        Productor productor = productorRepository.findById(id).orElseThrow();
        productorRepository.delete(productor);
    }
}

