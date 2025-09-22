package com.org.Roadmap.service;

import com.org.Roadmap.model.Roadmap;
import com.org.Roadmap.repository.RoadmapRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoadmapServiceImpl {
    @Autowired
    private RoadmapRepository roadmapRepository;
    private final ChatClient chatClient;

    public RoadmapServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public Roadmap getRoadmap(String domain) {
        return chatClient
                .prompt()
                .user("Give me the Roadmap for " + domain +
                        " in JSON format with fields: list of topic, list of subtopics, List of resources,certifications,avg_ctc, companies hire for " + domain)
                .call()
                .entity(Roadmap.class);
    }

    public void save_roadmap(Roadmap roadmap, Long userId) {
        roadmap.setId(null);
        roadmap.setUserId(userId);
        roadmapRepository.save(roadmap);
    }
}
