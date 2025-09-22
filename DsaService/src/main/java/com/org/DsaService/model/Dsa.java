package com.org.DsaService.model;

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
@Entity
public class Dsa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dId;
    private String topic_name;
    @OneToMany(mappedBy = "dsa", cascade = CascadeType.ALL, orphanRemoval = true)
    List<DsaQuestion> questions;
    private Long userId;
}
