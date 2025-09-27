package com.org.AtsChecker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private int score;
    private List<String> strengths;
    private List<String> missing;
    private List<String> suggestions;
    private int grammatical_score;
    private List<String> top3_resume_link_template;
}
