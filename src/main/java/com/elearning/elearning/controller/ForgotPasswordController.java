package com.elearning.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elearning.elearning.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ForgotPasswordController {

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