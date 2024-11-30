package com. example. suman. CRUD. config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for secure password encoding
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Updated way to disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user").permitAll() // Public access for /user
                        .anyRequest().authenticated() // Secure other endpoints
                )
                .formLogin(); // Enable basic authentication (optional for testing)

        return http.build();
    }
}
//package com. example. suman. CRUD. config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF protection (be cautious in production)
//                .authorizeRequests(auth -> auth
//                        .requestMatchers("/user").permitAll() // Allow access to /user endpoint without authentication (for both GET and POST)
//                        .anyRequest().authenticated() // Protect other endpoints
//                )
//                .logout(logout -> logout.disable()) // Disable logout functionality (optional)
//                .authenticationManager(authenticationManager -> authenticationManager) // No authentication manager (disables login)
//                .securityContext(securityContext -> securityContext.disable()); // Disable security context
//
//        return http.build();
//    }
//}
