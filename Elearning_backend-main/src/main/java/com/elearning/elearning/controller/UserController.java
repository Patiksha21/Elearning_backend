package com.elearning.elearning.controller;


import com.elearning.elearning.entity.User;
import com.elearning.elearning.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // 
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        Optional<User> validUser = userService.login(user.getEmail(), user.getPassword());
        Map<String, String> response = new HashMap<>();
        if (validUser.isPresent()) {
            response.put("message", "Login successful ✅");
            response.put("email", validUser.get().getEmail());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password ❌");
            return ResponseEntity.status(401).body(response);
        }
    }

    }

