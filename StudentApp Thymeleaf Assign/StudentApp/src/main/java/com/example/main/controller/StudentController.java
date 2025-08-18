
package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.main.entities.Student;
import com.example.main.entities.Student.Gender;
import com.example.main.services.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", service.listAll());
        return "index";
    }

    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("genders", Gender.values());
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", service.get(id));
        model.addAttribute("genders", Gender.values());
        return "student-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

