package com.example.seguroautos.controller;

import com.example.seguroautos.model.Cliente;
import com.example.seguroautos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllProductores() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
    	Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setEmail(clienteDetails.getEmail());
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
    	Cliente cliente = clienteRepository.findById(id).orElseThrow();
    	clienteRepository.delete(cliente);
    }
}

