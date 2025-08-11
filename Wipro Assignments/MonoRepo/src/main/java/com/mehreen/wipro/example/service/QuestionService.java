package com.mehreen.wipro.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehreen.wipro.example.entities.Question;
import com.mehreen.wipro.example.enums.Category;
import com.mehreen.wipro.example.repos.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
    
    private final QuestionRepository questionRepository;

    // GET by Category
    public List<Question> getQuestionsByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }

    // CREATE
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    // READ - All
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // READ - By ID
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    // UPDATE (Full)
    public Question updateQuestion(Long id, Question question) {
        Question existing = getQuestionById(id);

        // Replace all fields
        existing.setQuestionTitle(question.getQuestionTitle());
        existing.setOption1(question.getOption1());
        existing.setOption2(question.getOption2());
        existing.setOption3(question.getOption3());
        existing.setOption4(question.getOption4());
        existing.setCorrectAnswer(question.getCorrectAnswer());
        existing.setCategory(question.getCategory());
        existing.setDifficultyLevel(question.getDifficultyLevel());

        return questionRepository.save(existing);
    }

    // UPDATE (Partial)
    public Question patchQuestion(Long id, Question partialUpdate) {
        Question existing = getQuestionById(id);

        // Update only non-null fields
        if (partialUpdate.getQuestionTitle() != null) {
            existing.setQuestionTitle(partialUpdate.getQuestionTitle());
        }
        if (partialUpdate.getOption1() != null) {
            existing.setOption1(partialUpdate.getOption1());
        }
        if (partialUpdate.getOption2() != null) {
            existing.setOption2(partialUpdate.getOption2());
        }
        if (partialUpdate.getOption3() != null) {
            existing.setOption3(partialUpdate.getOption3());
        }
        if (partialUpdate.getOption4() != null) {
            existing.setOption4(partialUpdate.getOption4());
        }
        if (partialUpdate.getCorrectAnswer() != null) {
            existing.setCorrectAnswer(partialUpdate.getCorrectAnswer());
        }
        if (partialUpdate.getCategory() != null) {
            existing.setCategory(partialUpdate.getCategory());
        }
        if (partialUpdate.getDifficultyLevel() != null) {
            existing.setDifficultyLevel(partialUpdate.getDifficultyLevel());
        }

        return questionRepository.save(existing);
    }

    // DELETE
    public String deleteQuestion(Long id) {
        Question existing = getQuestionById(id);
        questionRepository.delete(existing);
        return "Question deleted successfully with id: " + id;
    }
}
