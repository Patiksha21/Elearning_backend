package com.elearning.elearning.controller;


import com.elearning.elearning.entity.RegisterUser;
import com.elearning.elearning.repository.RegisterUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    private final RegisterUserRepository repo;

    public ProfileController(RegisterUserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getProfile(@PathVariable String email) {
        Optional<RegisterUser> user = repo.findByEmail(email);
        if (user.isPresent()) {
            var u = user.get();
            Map<String, Object> profile = Map.of(
                "fullName", u.getFullName(),
                "email", u.getEmail(),
                "gender", u.getGender(),
                "dob", u.getDob(),
                "mobile", u.getMobile()
            );
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "User not found ❌"));
        }
    }
}
