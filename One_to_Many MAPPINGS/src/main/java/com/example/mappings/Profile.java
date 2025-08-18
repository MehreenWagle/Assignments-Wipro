package com.example.mappings;

import jakarta.persistence.*;

@Entity
@Table(name = "profile_table")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    // Many profiles -> One user
    @ManyToOne
    @JoinColumn(name = "user_id")   // foreign key column in profile_table
    private User user;

    public Profile() {}

    public Profile(Long id, String bio, User user) {
        this.id = id;
        this.bio = bio;
        this.user = user;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
