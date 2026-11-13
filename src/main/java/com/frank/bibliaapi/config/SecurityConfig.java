package com.frank.bibliaapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desactivamos CSRF porque trabajamos con una API REST stateless (con tokens JWT)
            .csrf(csrf -> csrf.disable())

            // Configuramos las reglas de acceso a las rutas
            .authorizeHttpRequests(auth -> auth
                // 1. Los versículos son públicos (cualquiera los puede leer sin iniciar sesión)
                .requestMatchers(HttpMethod.GET, "/api/v1/versiculos/**").permitAll()

                // 2. Notas y Favoritos son PRIVADOS (exigen token válido de Cognito)
                .requestMatchers("/api/v1/notas/**", "/api/v1/favoritos/**").authenticated()

                // 3. Cualquier otra ruta requiere autenticación por seguridad
                .anyRequest().authenticated()
            )

            // Configuramos la API como un Servidor de Recursos OAuth2 validando tokens JWT
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}