package com.elearning.elearning.controller;

import com.elearning.elearning.entity.User;
import com.elearning.elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.elearning.elearning.service.EmailService;

import java.util.Optional;
import java.util.UUID;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ForgotPasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        boolean userExists = checkIfUserExists(email);
        String genericSuccess = "If an account is associated with " + email + ", a password reset link has been sent.";

        if (userExists) {
            String secureToken = generateAndSaveToken(email);
            String resetLink = "https://yourfrontend.com/reset-password?token=" + secureToken;
            emailService.sendResetLink(email, resetLink);
        }

        return genericSuccess;
    }


    // ✅ New endpoint for testing email sending
    @PostMapping("/test-mail")
    public String testMail() {
        System.out.println("Inside test mail");
        emailService.sendResetLink("anandrawool5624@gmail.com", "https://example.com/reset");
        return "Mail triggered";
    }

    private boolean checkIfUserExists(String email) {
        return email.equalsIgnoreCase("user@example.com") ||
                email.equalsIgnoreCase("yourregisteredemail@gmail.com");
    }

    private String generateAndSaveToken(String email) {
        return "a-secure-random-uuid-token-12345";
    }


    @PostMapping("/send-reset")
    public ResponseEntity<String> sendResetLink(@RequestParam String email) {
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isEmpty()) {
            return ResponseEntity.badRequest().body("This email is not registered!");
        }
        String token = UUID.randomUUID().toString();
        String resetLink = "https://elearning.com/reset-password?token=" + token;
        emailService.sendResetLink(email, resetLink);
        return ResponseEntity.ok("Password reset link sent to " + email);
    }
}