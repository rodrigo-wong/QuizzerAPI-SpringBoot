package com.rodrigo.quizzer.Controller;

import com.rodrigo.quizzer.Model.Question;
import com.rodrigo.quizzer.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("difficulty={level}")
    public ResponseEntity<List<Question>> getQuestionsByDifficulty(@PathVariable String level){
        return questionService.getQuestionsByDifficulty(level);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
