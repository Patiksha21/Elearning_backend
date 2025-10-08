package com.elearning.elearning.repository;


import com.elearning.elearning.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    Optional<RegisterUser> findByEmail(String email);
}