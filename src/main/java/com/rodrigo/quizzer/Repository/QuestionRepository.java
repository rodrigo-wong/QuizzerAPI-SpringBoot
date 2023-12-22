package com.rodrigo.quizzer.Repository;

import com.rodrigo.quizzer.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByDifficulty(String difficulty);
    @Query(value = "SELECT * FROM Question WHERE difficulty = :difficulty ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestionsByDifficulty(String difficulty, int limit);
}
