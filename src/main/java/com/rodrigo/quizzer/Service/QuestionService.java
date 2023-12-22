package com.rodrigo.quizzer.Service;

import com.rodrigo.quizzer.Model.Question;
import com.rodrigo.quizzer.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList <>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getQuestionsByDifficulty(String level){
        try{
            return new ResponseEntity<>(questionRepository.findByDifficulty(level), HttpStatus.OK);
        } catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList <>(),HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<String> addQuestion(Question question){
        try{
            questionRepository.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("Failed to add question",HttpStatus.BAD_REQUEST);
    }
}
