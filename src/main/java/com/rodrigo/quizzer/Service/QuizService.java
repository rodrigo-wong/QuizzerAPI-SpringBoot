package com.rodrigo.quizzer.Service;

import com.rodrigo.quizzer.Model.Answer;
import com.rodrigo.quizzer.Model.Question;
import com.rodrigo.quizzer.Model.QuestionWrapper;
import com.rodrigo.quizzer.Model.Quiz;
import com.rodrigo.quizzer.Repository.QuestionRepository;
import com.rodrigo.quizzer.Repository.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String title, String difficulty, int limit) {
        try{
            List<Question> questions = questionRepository.findRandomQuestionsByDifficulty(difficulty, limit);
            Quiz quiz = new Quiz(title,questions);
            quizRepository.save(quiz);
            return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
        } catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("Failed to create Quiz", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id){
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()){
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionWrapper> wrappedQuestions = new ArrayList<>();
            for(Question q : questions){
                QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getTitle(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),q.getOptionE());
                wrappedQuestions.add(qw);
            }
            return new ResponseEntity<>(wrappedQuestions,HttpStatus.OK);
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> submitQuiz(List<Answer> answers, int id) {
        Optional<Quiz> quiz = quizRepository.findById(id);

        if(quiz.isPresent()){
            List<Question> questions = quiz.get().getQuestions();
            int points = 0;
            int totalQuestions = questions.size();
            for(int i = 0; i < answers.size(); i++){
               Answer a = answers.get(i);
               if(a.getId() == questions.get(i).getId()){
                   if(a.getAnswer().equals(questions.get(i).getAnswer())){
                       points++;
                   }
               }
            }
            return new ResponseEntity<>("You score is " + points + "/" + totalQuestions, HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to submit Quiz", HttpStatus.BAD_REQUEST);
    }
}
