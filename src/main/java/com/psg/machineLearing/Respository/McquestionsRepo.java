package com.psg.machineLearing.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psg.machineLearing.Model.Mcquestions;

public interface McquestionsRepo extends JpaRepository<Mcquestions, Integer> {

	boolean existsByQuestion(String question);
}
