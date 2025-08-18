package com.mehr.hibernate.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.mehr.hibernate.Gender;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roll_no", nullable = false, unique = true)
    private int rollNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    @Temporal(TemporalType.DATE)
    private Date dob;

    public User() {}

    public User(int rollNo, String firstName, String lastName, String username, Gender gender, String address, Date dob) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
    }

    // Getters, Setters, and toString()
}
