package com.example.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;
    private String teacherAddress;

    @Enumerated(EnumType.STRING)
    private Qualification qualification; // ✅ Enum stored as string in DB

    private int age;
    private LocalDate dob;
    private int experience;

    public enum Qualification {
        BSC, MSC, BEd, MEd, PHD
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }
    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public Qualification getQualification() {
        return qualification;
    }
    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
