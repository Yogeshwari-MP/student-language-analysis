package com.psg.machineLearing.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psg.machineLearing.Model.UserScore;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, Long> {
    UserScore findByUserId(String userId);
}
