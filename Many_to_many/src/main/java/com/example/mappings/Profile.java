package com.example.mappings;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile_table")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    // Many profiles <-> Many users
    @ManyToMany(mappedBy = "profiles")
    private List<User> users;

    public Profile() {}

    public Profile(Long id, String bio, List<User> users) {
        this.id = id;
        this.bio = bio;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
