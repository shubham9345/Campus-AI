package com.org.Quiz.Repository;

import com.org.Quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    List<Quiz> findQuizByUserId(Long userId);
}
