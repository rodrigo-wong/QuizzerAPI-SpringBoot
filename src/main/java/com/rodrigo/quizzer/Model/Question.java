package com.rodrigo.quizzer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String answer;
    private String difficulty;

}
