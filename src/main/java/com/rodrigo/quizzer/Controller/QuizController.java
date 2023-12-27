package com.rodrigo.quizzer.Controller;

import com.rodrigo.quizzer.Model.Answer;
import com.rodrigo.quizzer.Model.Question;
import com.rodrigo.quizzer.Model.QuestionWrapper;
import com.rodrigo.quizzer.Model.Quiz;
import com.rodrigo.quizzer.Service.QuizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

//    @PostMapping("create")
//    public ResponseEntity<String> createQuiz(@RequestParam String title, @RequestParam List<String> topics, @RequestParam int limit){
//        return quizService.createQuiz(title,topics,limit);
//    }
//    @GetMapping("get/{id}")
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
//        return quizService.getQuizQuestions(id);
//    }
//    @PostMapping("submit/{id}")
//    public ResponseEntity<String> submitQuiz(@RequestBody List<Answer> answers, @PathVariable int id){
//        return quizService.submitQuiz(answers,id);
//    }
}
