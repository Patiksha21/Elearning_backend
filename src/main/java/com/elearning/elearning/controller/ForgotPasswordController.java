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
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isEmpty()) {
            return ResponseEntity.badRequest().body("This email is not registered!");
        }
        String token = UUID.randomUUID().toString();

        // (You can store this token + expiry in DB if needed)
        // existingUser.get().setResetToken(token);
        // userRepository.save(existingUser.get());

        String resetLink = "https://elearning.com/reset-password?token=" + token;
        emailService.sendResetLink(email, resetLink);
        return ResponseEntity.ok("Password reset link sent to: " + email);
    }


    // ✅ New endpoint for testing email sending
    @PostMapping("/test-mail")
    public String testMail() {
        emailService.sendResetLink("morankarprathamesh@gmail.com", "https://example.com/reset");
        return "Mail triggered";
    }

    private boolean checkIfUserExists(String email) {
        return email.equalsIgnoreCase("user@example.com") ||
                email.equalsIgnoreCase("yourregisteredemail@gmail.com");
    }

    private String generateAndSaveToken(String email) {
        return "a-secure-random-uuid-token-12345";
    }
}