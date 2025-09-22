package com.org.Quiz.service;

import com.org.Quiz.model.Quiz;

import java.util.List;

public interface QuizService {
    public void saveQuiz(Quiz quiz, Long userId);
    public List<Quiz> getQuizByUserId(Long userId);
}
