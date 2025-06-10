package com.neoflex.model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    // Default constructor (optional but useful)
    public User() {}

    // Constructor with all fields
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username != null ? username.trim() : null;
        this.email = email != null ? email.trim() : null;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username != null ? username.trim() : null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email != null ? email.trim() : null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; // if using bcrypt, hash it before saving
    }
}

