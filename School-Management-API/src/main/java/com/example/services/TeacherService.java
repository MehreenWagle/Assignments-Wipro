package com.example.services;

import com.example.entities.Teacher;
import java.util.List;

public interface TeacherService {
	void deleteTeacher(Long id);

    Teacher saveTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    List<Teacher> findYoungTeachers(int age);
    List<Teacher> findByQualification(String qualification);
}