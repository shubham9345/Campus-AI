package com.org.DsaService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DsaQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qId;
    private Long question_no;
    private String question_title;
    private String question_link;
    private String difficulty_tag;
    private String companies;
    @ManyToOne
    @JoinColumn(name = "dsa_id")
    @JsonIgnore
    private Dsa dsa;
}
