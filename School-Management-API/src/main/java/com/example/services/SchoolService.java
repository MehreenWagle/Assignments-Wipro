package com.example.services;

import com.example.entities.School;
import java.util.List;

public interface SchoolService {
    School saveSchool(School school);
    School updateSchool(Long id, School school);
    School patchSchoolName(Long id, String newName);
    void deleteSchool(Long id);
    List<School> getAllSchools();
    List<School> getSchoolsByNativeQuery(String name);
    List<School> getSchoolsByTeacherExperience(int exp);
}