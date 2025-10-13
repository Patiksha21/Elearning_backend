package com.elearning.elearning.service;  // ⬅️ Assuming your service package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetLink(String toEmail, String resetLink) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("anandrawool5624@gmail.com");
            if (toEmail == null || !toEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                throw new IllegalArgumentException("Invalid email address: " + toEmail);
            }
            message.setTo(toEmail);
            message.setSubject("Password Reset Link - E-Learning Platform");
            message.setText(
                    "Hello,\n\n" +
                            "You requested a password reset for your E-Learning account.\n\n" +
                            "Click the link below to reset your password:\n" +
                            resetLink + "\n\n" +
                            "⚠️ Note: This link will expire in 15 minutes.\n" +
                            "If you didn’t request this, please ignore this email.\n\n" +
                            "Regards,\n" +
                            "E-Learning Platform Team"
            );

            mailSender.send(message);
            System.out.println("Reset email sent successfully to: " + toEmail);

        } catch (Exception e) {
            System.err.println("Failed to send reset email: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }
