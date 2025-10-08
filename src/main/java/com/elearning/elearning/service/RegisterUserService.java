package com.elearning.elearning.service;


import com.elearning.elearning.entity.RegisterUser;

import com.elearning.elearning.repository.RegisterUserRepository;

import org.springframework.stereotype.Service;

@Service

public class RegisterUserService {

    private final RegisterUserRepository registerRepo;

    public RegisterUserService(RegisterUserRepository registerRepo) {

        this.registerRepo = registerRepo;

    }

    public RegisterUser saveUser(RegisterUser user) {

        return registerRepo.save(user);

    }

    public boolean emailExists(String email) {

        return registerRepo.findByEmail(email).isPresent();

    }

}

