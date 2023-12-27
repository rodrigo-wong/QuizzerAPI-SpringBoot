package com.rodrigo.quizzer.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class QuizCreation {
    private ArrayList<String> topics;
    private String language;
    private int limit;
}
