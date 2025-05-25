package com.psg.machineLearing.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psg.machineLearing.Model.UserAnswer;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
	
	 @Query(value = "SELECT program, COUNT(*) AS correct_count FROM user_answer WHERE is_correct = 1 GROUP BY program", nativeQuery = true)
	    List<Object[]> getCorrectAnswerCountByProgram();
}