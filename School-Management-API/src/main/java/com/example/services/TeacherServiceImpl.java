package com.example.services;

import com.example.entities.Teacher;
import com.example.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> findYoungTeachers(int age) {
        return teacherRepository.findYoungTeachers(age);
    }

    @Override
    public List<Teacher> findByQualification(String qualification) {
        return teacherRepository.findByQualificationNative(qualification);
    }
    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }


    
    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        if (updatedTeacher.getTeacherName() != null)
            existingTeacher.setTeacherName(updatedTeacher.getTeacherName());

        if (updatedTeacher.getTeacherAddress() != null)
            existingTeacher.setTeacherAddress(updatedTeacher.getTeacherAddress());

        if (updatedTeacher.getQualification() != null)
            existingTeacher.setQualification(updatedTeacher.getQualification());

        if (updatedTeacher.getAge() != 0)
            existingTeacher.setAge(updatedTeacher.getAge());

        if (updatedTeacher.getDob() != null)
            existingTeacher.setDob(updatedTeacher.getDob());

        if (updatedTeacher.getExperience() != 0)
            existingTeacher.setExperience(updatedTeacher.getExperience());

        return teacherRepository.save(existingTeacher);
    }
    
 // ✅ Partial update method for Teacher
    public Teacher patchTeacher(Long id, Teacher updatedTeacher) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        if (updatedTeacher.getTeacherName() != null)
            existingTeacher.setTeacherName(updatedTeacher.getTeacherName());

        if (updatedTeacher.getTeacherAddress() != null)
            existingTeacher.setTeacherAddress(updatedTeacher.getTeacherAddress());

        if (updatedTeacher.getQualification() != null)
            existingTeacher.setQualification(updatedTeacher.getQualification());

        if (updatedTeacher.getAge() != 0)
            existingTeacher.setAge(updatedTeacher.getAge());

        if (updatedTeacher.getDob() != null)
            existingTeacher.setDob(updatedTeacher.getDob());

        if (updatedTeacher.getExperience() != 0)
            existingTeacher.setExperience(updatedTeacher.getExperience());

        return teacherRepository.save(existingTeacher);
    }

}
