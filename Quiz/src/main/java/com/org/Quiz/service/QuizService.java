package com.org.Quiz.service;

import com.org.Quiz.model.Quiz;

public interface QuizService {
    public void saveQuiz(Quiz quiz, Long userId);
}
