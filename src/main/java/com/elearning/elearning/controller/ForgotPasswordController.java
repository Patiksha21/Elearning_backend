package com.elearning.elearning.controller; // ⬅️ Assuming your controller package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.elearning.elearning.service.EmailService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class ForgotPasswordController {

    // Assuming EmailService is in com.example.project.service
    @Autowired
    private EmailService emailService;

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        // 🔹 Check if user exists in your database (TODO: Replace placeholder)
        boolean userExists = checkIfUserExists(email);

        // 🛑 SECURITY FIX: Always return a generic success message
        String genericSuccess = "If an account is associated with " + email + ", a password reset link has been sent.";

        if (userExists) {
            // 🔹 1. Generate a secure, unique, time-expiring reset token (e.g., using UUID)
            // 🔹 2. Store the token (and its expiry time) in the database linked to the user's account
            String secureToken = generateAndSaveToken(email); // ⬅️ Placeholder for real logic

            // 🔹 3. Construct the secure reset link
            String resetLink = "https://yourfrontend.com/reset-password?token=" + secureToken;

            // 🔹 4. Send email
            emailService.sendResetLink(email, resetLink);
        }

        // Return generic success message in all cases
        return genericSuccess;
    }

    private boolean checkIfUserExists(String email) {
        // 🚨 CRITICAL TODO: Replace this with actual database lookup (e.g., Spring Data JPA Repository)
        // Example: userRepository.findByEmailIgnoreCase(email).isPresent();
        return email.equalsIgnoreCase("user@example.com") ||
                email.equalsIgnoreCase("yourregisteredemail@gmail.com");
    }

    private String generateAndSaveToken(String email) {
        // 🚨 CRITICAL TODO: Implement actual secure token generation and database storage
        // A real token should be a secure UUID and should be saved in the DB with an expiry.
        // Returning a fake token for compile-time demonstration:
        return "a-secure-random-uuid-token-12345";
    }
}