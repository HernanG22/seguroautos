package com.example.seguroautos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager(http), jwtTokenProvider, userDetailsService);

        http
        .authorizeRequests()
        .antMatchers("/login/**").permitAll() // Permitir acceso al endpoint de login
        .antMatchers("/h2-console/**").permitAll() // Permitir acceso a la consola H2
        .antMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/webjars/**").permitAll()
       // .antMatchers("/**").permitAll()
        .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
        .and()
    .csrf().disable() // Deshabilitar CSRF si usas JWT u otro método de autenticación. Deshabilitar CSRF para facilitar pruebas con Postman
    .headers().frameOptions().disable() // Permitir el uso de iframes
    .and()
        .formLogin().disable() // Deshabilitar el manejo de formularios de inicio de sesión
        .httpBasic().disable(); // Deshabilitar autenticación básica HTTP si no la estás usando    
       //    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
