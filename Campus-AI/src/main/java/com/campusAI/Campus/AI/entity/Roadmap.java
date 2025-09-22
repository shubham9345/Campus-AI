package com.campusAI.Campus.AI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Roadmap {
    private Long id;
    private List<String> topics;
    private List<String> subtopics;
    private List<String> resources;
    private String certifications;
    private String avg_ctc;
    private String companies;
    private UserInfo user;
}
