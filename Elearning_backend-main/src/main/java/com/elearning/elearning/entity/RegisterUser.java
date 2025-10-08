package com.elearning.elearning.entity;


import jakarta.persistence.*;

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

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
	public Object getGender() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getDob() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getMobile() {
		// TODO Auto-generated method stub
		return null;
	}
}

