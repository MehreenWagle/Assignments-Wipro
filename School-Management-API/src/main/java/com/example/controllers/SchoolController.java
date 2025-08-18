package com.example.controllers;

import com.example.entities.School;
import com.example.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/add")
    public School save(@RequestBody School school) {
        return schoolService.saveSchool(school);
    }

    @PutMapping("/update/{id}")
    public School update(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @PatchMapping("/patch-name/{id}")
    public School patchName(@PathVariable Long id, @RequestParam String name) {
        return schoolService.patchSchoolName(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }

    @GetMapping("/all")
    public List<School> getAll() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/by-name")
    public List<School> getByName(@RequestParam String name) {
        return schoolService.getSchoolsByNativeQuery(name);
    }

    @GetMapping("/by-experience")
    public List<School> getByExperience(@RequestParam int exp) {
        return schoolService.getSchoolsByTeacherExperience(exp);
    }
}

