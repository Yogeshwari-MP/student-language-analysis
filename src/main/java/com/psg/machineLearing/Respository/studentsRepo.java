package com.psg.machineLearing.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psg.machineLearing.Model.formdetails;

public interface studentsRepo extends JpaRepository<formdetails, Integer> {

}
