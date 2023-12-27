package com.rodrigo.quizzer.Controller;

import com.rodrigo.quizzer.Model.Question;
import com.rodrigo.quizzer.Model.QuizCreation;
import com.rodrigo.quizzer.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("topic={topic}")
    public ResponseEntity<List<Question>> getQuestionsByTopic(@PathVariable String topic){
        return questionService.getQuestionsByTopic(topic);
    }
    @GetMapping("language={language}")
    public ResponseEntity<List<Question>> getQuestionsByLanguage(@PathVariable String language){
        return questionService.getQuestionsByLanguage(language);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PostMapping("quiz")
    public ResponseEntity<List<Question>> createQuiz(@RequestBody QuizCreation request){
        return questionService.getRandomQuestionByTopics(request);
    }
}
