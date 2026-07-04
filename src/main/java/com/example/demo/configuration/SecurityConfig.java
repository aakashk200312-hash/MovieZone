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

        http.csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth

        // ============================
        // PUBLIC APIs (No Login Needed)
        // ============================
        .requestMatchers(

                "/register",
                "/login",
                "/validateEmail",

                "/getMovies",
                "/getMovie/**",
                "/searchMovie/**",

                "/shows",
                "/show/**",

                "/swagger-ui/**",
                "/v3/api-docs/**"

        ).permitAll()


        // ============================
        // USER APIs
        // ============================
        .requestMatchers(

                "/addBooking",
                "/getBookings",
                "/searchBooking/**",
                "/updateBooking",
                "/patchBooking",
                "/deleteBooking/**",

                "/makePayment",
                "/payment/**",
                "/getPayments",

                "/updateUser",
                "/patchUser"

        ).hasAnyRole("USER","ADMIN")


        // ============================
        // ADMIN APIs
        // ============================
        .requestMatchers(

                "/addMovie",
                "/updateMovie",
                "/patchMovie",
                "/deleteMovie/**",

                "/addShow",
                "/updateShow",
                "/patchShow",
                "/deleteShow/**",

                "/getUsers",
                "/searchUser/**",
                "/deleteUser/**"

        ).hasRole("ADMIN")

        .anyRequest().authenticated()

        )

        .httpBasic(withDefaults());

        return http.build();
    }
}