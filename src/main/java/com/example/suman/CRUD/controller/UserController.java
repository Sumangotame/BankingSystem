package com.example.suman.CRUD.controller;

import com.example.suman.CRUD.model.User;
import com.example.suman.CRUD.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String home() {
        return "<div style='display: flex; align-items: center; justify-content: center; height: 100vh;'>"
                + "<h1 style='color: red; font-size: 3rem;'>Welcome to my banking app</h1>"
                + "</div>";
    }

    @GetMapping("/user")
    public List<User> user() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public Optional<User> singleUser(@PathVariable Long id) {
        System.out.println(id + " is id from localhost");
        return userService.getOneUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody @NotNull User users) {
        users.setPassword(passwordEncoder.encode(users.getPassword())); // Encrypting the password before saving
        return userService.saveUser(users);
    }
}
