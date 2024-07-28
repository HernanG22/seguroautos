package demopasswordbcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderDemo {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // La contraseña que deseas codificar
        String rawPassword = "admin";
        
        // Codificar la contraseña
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        System.out.println("Contraseña codificada: " + encodedPassword);
    }
}

