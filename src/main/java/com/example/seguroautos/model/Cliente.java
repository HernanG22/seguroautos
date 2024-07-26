package com.example.seguroautos.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    // Relación con Productor
    @ManyToOne
    @JoinColumn(name = "productor_id")
    private Productor productor;

    // Relación con VehículoAsegurado
    @OneToMany(mappedBy = "cliente")
    private List<VehiculoAsegurado> vehiculosAsegurados;

    // Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
