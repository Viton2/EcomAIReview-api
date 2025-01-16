package com.vitor.oliveira.ecomaireviewapi.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "test/anon", "test/anon/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "test/admin", "/test/admin/**").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/test/user").hasAnyRole(ADMIN, USER)
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth -> oauth
                        .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter)))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

//        http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET, "/test/anonymous", "/test/anonymous/**").permitAll()
//                .requestMatchers(HttpMethod.GET, "/test/admin", "/test/admin/**").hasRole(ADMIN)
//                .requestMatchers(HttpMethod.GET, "/test/user").hasAnyRole(ADMIN, USER)
//                .anyRequest().authenticated();
//        http.oauth2ResourceServer()
//                .jwt()
//                .jwtAuthenticationConverter(jwtAuthConverter);
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        return http.build();
    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/**",
//                                    "/swagger-ui/index.html",
//                                    "/login")
//                            .permitAll();
//                })
//                .build();
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000", "https://effycity-web.vercel.app")); // Permitir todas as origens
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH"));
        configuration.setAllowedHeaders(List.of("*")); // Permitir todos os headers
//        configuration.setAllowCredentials(true); // Permitir envio de credenciais (cookies, auth headers)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
