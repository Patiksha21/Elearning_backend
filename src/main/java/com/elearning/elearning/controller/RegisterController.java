package com.elearning.elearning.controller;

import com.elearning.elearning.entity.RegisterUser;
import com.elearning.elearning.entity.User;
import com.elearning.elearning.service.RegisterUserService;
import com.elearning.elearning.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")
public class RegisterController {

    private final RegisterUserService registerService;
    private final UserService userService;

    public RegisterController(RegisterUserService registerService, UserService userService) {
        this.registerService = registerService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterUser user) {
        // 🔹 Check if email already exists
        if (registerService.emailExists(user.getEmail())) {
            return ResponseEntity.status(409).body("Email already exists ❌");
        }

        // 🔹 Save full details into register_users table
        registerService.saveUser(user);

        // 🔹 Also save email + password into users table for login
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        userService.register(newUser);

        return ResponseEntity.ok("User registered successfully ✅");
    }
}