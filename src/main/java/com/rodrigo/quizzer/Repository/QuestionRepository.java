package com.rodrigo.quizzer.Repository;

import com.rodrigo.quizzer.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByTopic(String topic);
    @Query(value = "SELECT * FROM (" +
            "    SELECT *, " +
            "        ROW_NUMBER() OVER (PARTITION BY topic ORDER BY RANDOM()) as row_num " +
            "    FROM " +
            "        Question " +
            "    WHERE " +
            "        LOWER(language) = LOWER(:language) AND LOWER(topic) IN :topics" +
            ") AS numbered_questions " +
            "WHERE " +
            "    row_num <= :limit", nativeQuery = true)
    List<Question> findRandomQuestionsByTopics(@Param("language") String language, @Param("topics") List<String> topics, @Param("limit") int limit);

    List<Question> findByLanguage(String language);
}
