package com.org.Quiz.service;


import com.org.Quiz.Repository.QuizRepository;
import com.org.Quiz.model.Quiz;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService{
    private final ChatClient chatClient;
    @Autowired
    private QuizRepository quizRepository;

    public QuizServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public Quiz getQuizQuestions(String topic) {
        return chatClient
                .prompt()
                .user("Give me the 2 questions for " + topic +
                        " in JSON format with fields: topics_name,inside list of quiz_question each have fields question_no, List of options , answer of that question")
                .call()
                .entity(Quiz.class);
    }
    public void saveQuiz(Quiz quiz, Long userId) {
        quiz.setQuizId(null);
        quiz.setUserId(userId);
        quizRepository.save(quiz);
    }
}