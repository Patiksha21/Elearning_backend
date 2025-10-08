package com.elearning.elearning.controller;


import com.elearning.elearning.entity.RegisterUser;
import com.elearning.elearning.repository.RegisterUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/forgot-password")
@CrossOrigin(origins = "*")
public class ForgotPasswordController {

    private final RegisterUserRepository registerRepo;

    public ForgotPasswordController(RegisterUserRepository registerRepo) {
        this.registerRepo = registerRepo;
    }

    @PostMapping
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        Optional<RegisterUser> userOpt = registerRepo.findByEmail(email);

        if (userOpt.isPresent()) {
            // For now, just return success. 
            // Later you can generate reset tokens + send email link.
            return ResponseEntity.ok("Password reset link sent to " + email + " ✅");
        } else {
            return ResponseEntity.status(404).body("Email not registered ❌");
        }
    }

    // Endpoint for updating password directly
    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestParam String email,
                                                @RequestParam String newPassword) {
        Optional<RegisterUser> userOpt = registerRepo.findByEmail(email);

        if (userOpt.isPresent()) {
            RegisterUser user = userOpt.get();
            user.setPassword(newPassword); // ⚠️ store encrypted password in real apps
            registerRepo.save(user);
            return ResponseEntity.ok("Password updated successfully ✅");
        } else {
            return ResponseEntity.status(404).body("User not found ❌");
        }
    }
}

