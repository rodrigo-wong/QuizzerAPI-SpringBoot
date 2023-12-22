package com.rodrigo.quizzer.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> questions;

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }
}
