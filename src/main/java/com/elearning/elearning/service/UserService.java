package com.elearning.elearning.service;


import com.elearning.elearning.entity.User;

import com.elearning.elearning.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    public User register(User user) {

        return userRepository.save(user); // Save new user

    }

    public Optional<User> login(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {

            return user; // ✅ Login success

        }

        return Optional.empty(); // ❌ Login failed

    }

}

