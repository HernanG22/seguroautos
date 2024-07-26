package com.example.seguroautos.controller;

import com.example.seguroautos.model.VehiculoAsegurado;
import com.example.seguroautos.repository.VehiculoAseguradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculoasegurado")
public class VehiculoAseguradoController {

    @Autowired
    private VehiculoAseguradoRepository vehiculoaseguradoRepository;

    @GetMapping
    public List<VehiculoAsegurado> getAllProductores() {
        return vehiculoaseguradoRepository.findAll();
    }

    @PostMapping
    public VehiculoAsegurado createVehiculoAsegurado(@RequestBody VehiculoAsegurado vehiculoasegurado) {
        return vehiculoaseguradoRepository.save(vehiculoasegurado);
    }

    @GetMapping("/{id}")
    public VehiculoAsegurado getVehiculoAseguradoById(@PathVariable Long id) {
        return vehiculoaseguradoRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public VehiculoAsegurado updateVehiculoAsegurado(@PathVariable Long id, @RequestBody VehiculoAsegurado vehiculoaseguradoDetails) {
    	VehiculoAsegurado vehiculoasegurado = vehiculoaseguradoRepository.findById(id).orElseThrow();
    	vehiculoasegurado.setMarca(vehiculoaseguradoDetails.getMarca());
    	vehiculoasegurado.setModelo(vehiculoaseguradoDetails.getModelo());
    	vehiculoasegurado.setAño(vehiculoaseguradoDetails.getAño());
    	vehiculoasegurado.setPlaca(vehiculoaseguradoDetails.getPlaca());
    	return vehiculoaseguradoRepository.save(vehiculoasegurado);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculoAsegurado(@PathVariable Long id) {
    	VehiculoAsegurado vehiculoasegurado = vehiculoaseguradoRepository.findById(id).orElseThrow();
    	vehiculoaseguradoRepository.delete(vehiculoasegurado);
    }
}

