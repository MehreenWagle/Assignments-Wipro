package com.mehreen.wipro.example.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.mehreen.wipro.example.entities.Question;
import com.mehreen.wipro.example.enums.Category;
import com.mehreen.wipro.example.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // CREATE
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // READ - Get all
    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // READ - Get by ID
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    // READ - Get by category (Enum)
    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable Category category) {
        return questionService.getQuestionsByCategory(category);
    }

    // UPDATE (Full Update)
    @PutMapping("/update/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    // UPDATE (Partial Update)
    @PatchMapping("/update/{id}")
    public Question patchQuestion(@PathVariable Long id, @RequestBody Question partialUpdate) {
        return questionService.patchQuestion(id, partialUpdate);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        return questionService.deleteQuestion(id);
    }
}
