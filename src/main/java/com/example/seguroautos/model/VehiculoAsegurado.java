package com.example.seguroautos.model;

import javax.persistence.*;

@Entity
public class VehiculoAsegurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int año;
    private String placa;

    // Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

    // Getters y Setters
}
