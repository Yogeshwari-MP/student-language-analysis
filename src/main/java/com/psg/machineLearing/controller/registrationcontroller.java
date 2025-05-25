package com.psg.machineLearing.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.psg.machineLearing.Model.Mcquestions;
import com.psg.machineLearing.Model.Question;
import com.psg.machineLearing.Model.UserAnswer;
import com.psg.machineLearing.Model.formdetails;
import com.psg.machineLearing.Respository.McquestionsRepo;
import com.psg.machineLearing.Respository.UserAnswerRepository;
import com.psg.machineLearing.Respository.studentsRepo;
import com.psg.machineLearing.Service.MovieService;
import com.psg.machineLearing.Service.QuizService;



@Controller
public class registrationcontroller {
	
	@Autowired
	studentsRepo studentrep;
	
	@Autowired
	McquestionsRepo Mcqquestionrep;
	
	 @Autowired
	    private MovieService movieService;
	 

	 
	 @Autowired
	    private QuizService quizService;
	
	@RequestMapping("/registration")
	   public ModelAndView register() {
		   ModelAndView mod = new ModelAndView("design");
		   return mod;
	   }
	
	@RequestMapping("/quizes")
	   public ModelAndView quizs(@RequestParam("student_name") String name,
			    @RequestParam("student_rollnum") String rollNumber,
			    @RequestParam("department_name") String department,
			    @RequestParam("prefered_language") String language,Model model) {
		   ModelAndView mod = new ModelAndView("quiz");
		   List<Question> fullQuestions = movieService.getAllProgrammingQuestions();  

		   for (Question q : fullQuestions) {
		       Map<String, String> options = q.getOptions();

		       // Check if the question already exists in the database
		       if (!Mcqquestionrep.existsByQuestion(q.getQuestion())) {
		           Mcquestions quizQuestion = new Mcquestions(
		               q.getQuestion(),
		               options.get("a"),
		               options.get("b"),
		               options.get("c"),
		               q.getAnswer(),
		               q.getProgram()
		           );

		           // Save only if the question is not already present
		           Mcqquestionrep.save(quizQuestion);
		       } else {
		           System.out.println("Skipping duplicate question: " + q.getQuestion());
		       }
		   }
		    
		    // Convert into a list of maps containing only question and options
		    List<Map<String, Object>> filteredQuestions = ((Collection<Question>) fullQuestions).stream()
		        .map(q -> Map.of("question", q.getQuestion(), "options", q.getOptions(),"answer",q.getAnswer(),"program",q.getProgram()))
		        .collect(Collectors.toList());
		    
		    model.addAttribute("questions", filteredQuestions);
		   
		   return mod;
	   }
	
	
	@RequestMapping("/savedetails")
	public ResponseEntity<String> savedetail(@RequestBody formdetails form){
		
		formdetails getform = new formdetails();
		getform.setStudent_name(form.getStudent_name());
		getform.setStudent_rollnum(form.getStudent_rollnum());
		getform.setDepartment_name(form.getDepartment_name());
		getform.setPrefered_language(form.getPrefered_language());
		studentrep.save(getform);
		
		return ResponseEntity.ok("Details saved successfully!");
		
	}
	
	@RequestMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody Map<String, Object> requestData) {
        String userId = (String) requestData.get("userId");
        List<Map<String, Object>> responses = (List<Map<String, Object>>) requestData.get("responses");

        List<UserAnswer> userAnswers = responses.stream().map(response -> {
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setQuestionId(response.get("questionIndex").toString());
            userAnswer.setSelectedOption(response.get("selectedOption").toString());
            userAnswer.setCorrect(Boolean.parseBoolean(response.get("isCorrect").toString()));
            userAnswer.setProgram(response.get("program").toString());
            return userAnswer;
        }).toList();

        quizService.saveUserResponses(userId, userAnswers);
        return ResponseEntity.ok("Quiz submitted successfully!");
    }
	
	

}
