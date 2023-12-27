package com.rodrigo.quizzer.Service;

import com.rodrigo.quizzer.Model.Question;
import com.rodrigo.quizzer.Model.QuizCreation;
import com.rodrigo.quizzer.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<Question>> getQuestionsByTopic(String topic){
        try{
            return new ResponseEntity<>(questionRepository.findByTopic(topic), HttpStatus.OK);
        } catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList <>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getRandomQuestionByTopics(QuizCreation request){
        try{
            List<String> topics = request.getTopics().stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
            String language = request.getLanguage().toLowerCase();
            int limit = request.getLimit();

            List<Question> questions = questionRepository.findRandomQuestionsByTopics(language, topics, limit);

            return new ResponseEntity<>(questions, HttpStatus.OK);
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

    public ResponseEntity<List<Question>> getQuestionsByLanguage(String language) {
        try{
            return new ResponseEntity<>(questionRepository.findByLanguage(language), HttpStatus.OK);
        } catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList <>(),HttpStatus.BAD_REQUEST);
    }
}
