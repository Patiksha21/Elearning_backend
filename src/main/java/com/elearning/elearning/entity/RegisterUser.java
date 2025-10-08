package com.elearning.elearning.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Table(name = "register_users")

public class RegisterUser {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)

    private String email;

    private String password;

    private String gender;

    private LocalDate dob;

    private String mobile;

    // ✅ Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

}

