package com.org.AtsChecker.service;

import com.org.AtsChecker.model.Resume;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AtsService {
    private final ChatClient chatClient;

    public AtsService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public Resume analyzeResume(String resumeText, String jobDescription) {
        return chatClient.prompt()
                .user("""
                        You are an ATS (Applicant Tracking System) evaluator. 
                        Compare the given RESUME with the JOB DESCRIPTION. 
                        
                        - Give an ATS score out of 100.
                        - List strengths.
                        - List missing keywords/skills.
                        - Give 3-5 improvement suggestions.
                        - give grammatical correctness score out of 100
                        - list of top 3 resume template link from overleaf.com
                        
                        Format response in JSON with fields: score, list of strengths, missing, suggestions,grammatical_score,top3_resume_link_template.
                        
                        RESUME:
                        """ + resumeText + "\n\nJOB DESCRIPTION:\n" + jobDescription)
                .call()
                .entity(Resume.class);

    }
}
