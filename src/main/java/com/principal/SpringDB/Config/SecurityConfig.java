package com.principal.SpringDB.Config;

import com.principal.SpringDB.EntidadesTablas.TablaUsuarios;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager usuarios() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password("{noop}1234")
                        .roles("USER")
                        .build(),
                User.withUsername("admin")
                        .password("{noop}4321")
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth.requestMatchers("/v1/guardar").permitAll()
                        .requestMatchers("/v1/agregar").permitAll()
                        .requestMatchers("/v1/prueba").permitAll()
                        .requestMatchers("/v1/cambiar/").permitAll()
                        .requestMatchers("/v1/borrar/").permitAll()
                        .requestMatchers("/v1/footer/admin").hasRole("ADMIN").anyRequest().authenticated()
                )
                .formLogin(form -> form.defaultSuccessUrl("/v1/prueba"))
                .build();
    }
}
