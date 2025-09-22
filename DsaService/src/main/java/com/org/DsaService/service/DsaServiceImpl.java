package com.org.DsaService.service;

import com.org.DsaService.model.Dsa;
import com.org.DsaService.repository.DsaRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DsaServiceImpl implements DsaService {
    private final ChatClient chatClient;

    public DsaServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @Autowired
    private DsaRepository dsaRepository;

    public Dsa getDsaQuestions(String topic) {
        return chatClient
                .prompt()
                .user(
                        "Generate 5 unique DSA questions for the topic: " + topic +
                                ". Return the output strictly in JSON format with fields: " +
                                "topic_name, questions (list of objects with fields: question_no, question_title, question_link, difficulty_tag, companies). " +
                                "Constraints: " +
                                "1. Each call must produce a different set of questions, even for the same topic (use variation and avoid repetition). " +
                                "2. Do not repeat previously used questions. " +
                                "3. Ensure questions come from well-known coding platforms like LeetCode, Codeforces, GeeksforGeeks, HackerRank, or InterviewBit. " +
                                "4. Vary difficulty tags across the set (easy, medium, hard). " +
                                "5. Companies field must contain at least 2 real companies where this question is known to be asked. " +
                                "6. Make question_link valid URLs. " +
                                "7. Ensure all JSON fields are always present."
                )
                .call()
                .entity(Dsa.class);
    }

    @Override
    public void saveDsa(Dsa dsa, Long userId) {
        dsa.setUserId(userId);
        dsa.setDId(null);

        if (dsa.getQuestions() != null) {
            dsa.getQuestions().forEach(q -> {
                q.setQId(null);
                q.setDsa(dsa);
            });
        }
        dsaRepository.save(dsa);
    }


    @Override
    public List<Dsa> getDsaByUserId(Long userId) {
        return dsaRepository.findDsaQuestionByUserId(userId);
    }
}

