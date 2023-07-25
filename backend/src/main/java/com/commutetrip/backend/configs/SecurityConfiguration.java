package com.commutetrip.backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated())
                .oauth2Login(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }
}