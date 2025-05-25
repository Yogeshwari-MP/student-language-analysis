package com.psg.machineLearing.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "MCQQUESTIONS")
public class Mcquestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "QUESTION",nullable = false)
    private String question;

    @Column(name = "OPTION_A",nullable = false)
    private String optionA;

    @Column(name = "OPTION_B",nullable = false)
    private String optionB;

    @Column(name = "OPTION_C",nullable = false)
    private String optionC;

    @Column(name = "ANSWER",nullable = false)
    private String answer;
    
    @Column(name = "PROGRAM",nullable = false)
    private String program;

    // ✅ Default Constructor (Required for JPA)
    public Mcquestions() {
    }

    // ✅ Corrected Parameterized Constructor
    public Mcquestions(String question, String optionA, String optionB, String optionC, String answer,String program) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.answer = answer;
        this.program=program;
    }

    // ✅ Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
    
    
}
