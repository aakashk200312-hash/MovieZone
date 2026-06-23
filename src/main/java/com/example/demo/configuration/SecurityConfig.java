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

                // ==========================
                // PUBLIC APIs (Guest User)
                // ==========================
                .requestMatchers(

                        // Authentication
                        "/register",
                        "/login",
                        "/validateEmail",

                        // Movie Browsing
                        "/getMovies",
                        "/getMovie/**",
                        "/searchMovie/**",

                        // Swagger
                        "/swagger-ui/**",
                        "/v3/api-docs/**"

                ).permitAll()

                // ==========================
                // USER APIs (After Login)
                // ==========================
                .requestMatchers(

                        // Booking
                        "/addBooking",
                        "/getBookings",
                        "/searchBooking/**",
                        "/updateBooking",
                        "/patchBooking",
                        "/deleteBooking/**",

                        // User Profile
                        "/getUser/**",
                        "/updateUser",
                        "/patchUser"

                ).authenticated()

                // ==========================
                // ADMIN APIs
                // ==========================
                .requestMatchers(

                        // User Management
                        "/getUsers",
                        "/deleteUser/**",

                        // Movie Management
                        "/addMovie",
                        "/updateMovie",
                        "/patchMovie",
                        "/deleteMovie/**"

                ).authenticated()

                // Any other API
                .anyRequest().authenticated()

            )

            // Basic Authentication
            .httpBasic(withDefaults());

        return http.build();
    }
}