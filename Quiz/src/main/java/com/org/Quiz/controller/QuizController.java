package com.org.Quiz.controller;

import com.org.Quiz.model.Quiz;
import com.org.Quiz.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizServiceImpl quizServiceImpl;

    @GetMapping("/{userId}")
    public Quiz generateQuiz(@RequestParam String topic, @RequestParam(defaultValue = "false") boolean save, @PathVariable Long userId) {
        Quiz generatedQuizes = quizServiceImpl.getQuizQuestions(topic);
        if (save) {
            quizServiceImpl.saveQuiz(generatedQuizes, userId);
        }
        return generatedQuizes;
    }
}
