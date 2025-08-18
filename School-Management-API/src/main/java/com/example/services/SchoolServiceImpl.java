package com.example.services;

import com.example.entities.School;
import com.example.entities.Teacher;
import com.example.Repository.SchoolRepository;
import com.example.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchool(Long id, School updatedSchool) {
        School existingSchool = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));

        // Update only provided fields
        if (updatedSchool.getSchoolName() != null) {
            existingSchool.setSchoolName(updatedSchool.getSchoolName());
        }
        if (updatedSchool.getSchoolAddress() != null) {
            existingSchool.setSchoolAddress(updatedSchool.getSchoolAddress());
        }

        // Handle teacher update/linking
        if (updatedSchool.getTeacher() != null) {
            Teacher updatedTeacher = updatedSchool.getTeacher();

            if (updatedTeacher.getId() != null) {
                // Link existing teacher by ID
                Teacher existingTeacher = teacherRepository.findById(updatedTeacher.getId())
                        .orElseThrow(() -> new RuntimeException("Teacher not found"));
                existingSchool.setTeacher(existingTeacher);
            } else {
                // Update teacher details (if already linked)
                Teacher teacher = existingSchool.getTeacher() != null
                        ? existingSchool.getTeacher()
                        : new Teacher();

                if (updatedTeacher.getTeacherName() != null) teacher.setTeacherName(updatedTeacher.getTeacherName());
                if (updatedTeacher.getTeacherAddress() != null) teacher.setTeacherAddress(updatedTeacher.getTeacherAddress());
                if (updatedTeacher.getQualification() != null) teacher.setQualification(updatedTeacher.getQualification());
                if (updatedTeacher.getAge() != 0) teacher.setAge(updatedTeacher.getAge());
                if (updatedTeacher.getDob() != null) teacher.setDob(updatedTeacher.getDob());
                if (updatedTeacher.getExperience() != 0) teacher.setExperience(updatedTeacher.getExperience());

                existingSchool.setTeacher(teacher);
            }
        }

        return schoolRepository.save(existingSchool);
    }

    @Override
    public School patchSchoolName(Long id, String newName) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));
        school.setSchoolName(newName);
        return schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public List<School> getSchoolsByNativeQuery(String name) {
        return schoolRepository.findBySchoolNameNative(name);
    }

    @Override
    public List<School> getSchoolsByTeacherExperience(int exp) {
        return schoolRepository.findSchoolsWithExperiencedTeachers(exp);
    }
}
