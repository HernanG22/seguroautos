package com.example.seguroautos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.seguroautos.model.app_User;
import com.example.seguroautos.repository.app_UserRepository; // Asegúrate de que el repositorio esté correctamente importado

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private app_UserRepository userRepository; // Asegúrate de que este repositorio esté correctamente implementado

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	app_User user = userRepository.findByUsername(username); // Asegúrate de tener este método en tu repositorio
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>()); // Ajusta los roles y permisos según sea necesario
    }
}

