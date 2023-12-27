package com.rodrigo.quizzer.Repository;

import com.rodrigo.quizzer.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
