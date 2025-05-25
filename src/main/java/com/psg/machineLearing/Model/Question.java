package com.psg.machineLearing.Model;

import java.util.Map;

public class Question {

     // ✅ Added to match JSON structure
    private String question;
    private Map<String, String> options;  // ✅ Changed from List<Map<String, String>> to Map<String, String>
    private String answer;
    private String program;

    public Question() {}

    public Question( String question, Map<String, String> options, String answer,String program) {
      
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.program=program;
    }

   

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
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
