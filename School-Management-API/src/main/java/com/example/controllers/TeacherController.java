package com.example.controllers;

import com.example.entities.Teacher;
import com.example.services.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @PostMapping("/add")
    public Teacher add(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/all")
    public List<Teacher> all() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/by-age")
    public List<Teacher> byAge(@RequestParam int age) {
        return teacherService.findYoungTeachers(age);
    }

    @GetMapping("/by-qualification")
    public List<Teacher> byQualification(@RequestParam String qualification) {
        return teacherService.findByQualification(qualification);
    }

    
    @PutMapping("/update/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }
    @PatchMapping("/patch/{id}")
    public Teacher patchTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.patchTeacher(id, teacher);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }


}
