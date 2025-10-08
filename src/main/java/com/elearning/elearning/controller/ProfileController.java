package com.elearning.elearning.controller;

import com.elearning.elearning.entity.RegisterUser;
import com.elearning.elearning.repository.ProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    private final ProfileRepository repo; // <- Correct repository

    public ProfileController(ProfileRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getProfile(@PathVariable String email) {
        Optional<RegisterUser> userOpt = repo.findByEmail(email);

        if (userOpt.isPresent()) {
            RegisterUser user = userOpt.get();

            Map<String, Object> profile = Map.of(
                    "fullName", user.getFullName(),
                    "email", user.getEmail(),
                    "gender", user.getGender(),
                    "dob", user.getDob(),
                    "mobile", user.getMobile()
            );

            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "User not found ❌"));
        }
    }
}