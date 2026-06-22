package com.example.demo.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // ===== Public APIs =====
                .requestMatchers(

                        // User Registration
                        "/addUser",
                        "/validateEmail",

                        // Movie APIs
                        "/getMovies",
                        "/getMovie/**"                       
                ).permitAll()


                // ===== User APIs (Login Required) =====
                .requestMatchers(

                        "/addBooking",
                        "/searchBooking/**",
                        "/updateBooking",
                        "/patchBooking",
                        "/deleteBooking/**"

                ).authenticated()


                // ===== Admin APIs (Login Required) =====
                .requestMatchers(

                        // User Management
                        "/getUsers",
                        "/getUser/**",
                        "/deleteUser/**",

                        // Movie Management
                        "/addMovie",
                        "/updateMovie",
                        "/patchMovie",
                        "/deleteMovie/**",

                        // Booking Management
                        "/getBookings",
                        
                        // Swagger
                        "/swagger-ui/**",
                        "/v3/api-docs/**"


                ).authenticated()

                // Any other request
                .anyRequest().authenticated()
            )

            // Basic Authentication
            .httpBasic(withDefaults());

        return http.build();
    }
}