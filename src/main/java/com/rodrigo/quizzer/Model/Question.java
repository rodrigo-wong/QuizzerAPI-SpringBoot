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
    private Integer question_id;
    private String title;
    private String language;
    private String topic;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

}
