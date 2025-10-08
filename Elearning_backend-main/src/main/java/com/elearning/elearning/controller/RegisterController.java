package com.elearning.elearning.controller;


import com.elearning.elearning.entity.RegisterUser;
import com.elearning.elearning.service.RegisterUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")
public class RegisterController {

    private final RegisterUserService registerService;

    public RegisterController(RegisterUserService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterUser user) {
        if (registerService.emailExists(user.getEmail())) {
            return ResponseEntity.status(409).body("Email already exists ❌");
        }

        registerService.saveUser(user);
        return ResponseEntity.ok("User registered successfully ✅");
    }
}

