package com.example.suman.CRUD.service;

import com.example.suman.CRUD.model.AppUser;
import com.example.suman.CRUD.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user from database
        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return the UserDetails with the encoded password (no need to re-encode)
        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword()) // Use already encoded password
                .roles(appUser.getRole()) // Assuming roles are stored as a single role, modify as needed
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + appUser.getRole()))) // If roles are strings
                .build();
    }
}
