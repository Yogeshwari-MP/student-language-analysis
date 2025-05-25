package com.psg.machineLearing.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserAnswer {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String userId;
	    private String questionId;
	    private String selectedOption;
	    private boolean isCorrect;
	    private String program;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getQuestionId() {
			return questionId;
		}
		public void setQuestionId(String questionId) {
			this.questionId = questionId;
		}
		public String getSelectedOption() {
			return selectedOption;
		}
		public void setSelectedOption(String selectedOption) {
			this.selectedOption = selectedOption;
		}
		public boolean isCorrect() {
			return isCorrect;
		}
		public void setCorrect(boolean isCorrect) {
			this.isCorrect = isCorrect;
		}
		public String getProgram() {
			return program;
		}
		public void setProgram(String program) {
			this.program = program;
		}
	    
	    
	    
	    

}
