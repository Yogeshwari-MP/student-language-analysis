package com.psg.machineLearing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psg.machineLearing.Respository.UserAnswerRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
    private UserAnswerRepository userAnswerRepository;

    @GetMapping("/correctAnswersByProgram")
    public List<Map<String, Object>> getCorrectAnswersByProgram() {
        List<Object[]> results = userAnswerRepository.getCorrectAnswerCountByProgram();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("program", result[0]); // Programming Language
            map.put("correct_count", result[1]); // Correct Answers Count
            responseList.add(map);
        }
        return responseList;
    }
}
