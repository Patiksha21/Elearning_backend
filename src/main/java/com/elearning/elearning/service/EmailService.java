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
        SimpleMailMessage message = new SimpleMailMessage();

        // 💡 OPTIONAL: Set a "from" address if not configured globally
        // message.setFrom("no-reply@yourplatform.com");

        message.setTo(toEmail);
        message.setSubject("Password Reset Link - E-Learning Platform");
        message.setText("Click the link below to reset your password:\n\n" + resetLink +
                "\n\nThis link will expire in [e.g., 15 minutes]. If you didn’t request this, please ignore this email.");

        // NOTE: This can throw an exception if the mail server config is incorrect or unavailable.
        mailSender.send(message);
    }
}