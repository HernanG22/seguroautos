package com.example.seguroautos.model;

import javax.persistence.*;

@Entity
public class app_User {

    @Id
    private String username;
    
    private String password; // La contraseña debe estar cifrada

    // Getters y setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    // Otros campos como roles, etc.

}

