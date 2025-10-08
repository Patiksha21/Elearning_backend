package com.elearning.elearning.controller;


import com.elearning.elearning.entity.Quiz;
import com.elearning.elearning.repository.QuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizRepository repository;

    public QuizController(QuizRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody Quiz submission) {
        repository.save(submission);
        return ResponseEntity.ok("Score saved successfully!");
    }
}

