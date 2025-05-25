package com.psg.machineLearing.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psg.machineLearing.Model.UserAnswer;
import com.psg.machineLearing.Model.UserScore;
import com.psg.machineLearing.Respository.UserAnswerRepository;
import com.psg.machineLearing.Respository.UserScoreRepository;

@Service
public class QuizService {
    
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Autowired
    private UserScoreRepository userScoreRepository;

    public void saveUserResponses(String userId, List<UserAnswer> responses) {
        int totalScore = 0;

        for (UserAnswer response : responses) {
            // Check if the answer is correct (Assuming correct answer logic is handled)
            if (response.isCorrect()) {
                totalScore += 1;
            }
            response.setUserId(userId);
            userAnswerRepository.save(response);
        }

        // Save the total score
        UserScore userScore = userScoreRepository.findByUserId(userId);
        if (userScore == null) {
            userScore = new UserScore();
            userScore.setUserId(userId);
        }
        userScore.setTotalScore(totalScore);
        userScoreRepository.save(userScore);
    }
}