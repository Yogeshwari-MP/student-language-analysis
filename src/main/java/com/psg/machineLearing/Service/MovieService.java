package com.psg.machineLearing.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psg.machineLearing.Model.Movie;
import com.psg.machineLearing.Model.Question;
import com.psg.machineLearing.Respository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private final String ML_MODEL_URL = "http://127.0.0.1:5000/recommend/all";

    public List<Movie> getAllMovies() {
    	
    	List<Movie> test = movieRepository.allMovie();
    	
        return test;
    }

//    public List<Movie> getRecommendations(int userId) {
//        RestTemplate restTemplate = new RestTemplate();
//        int[] recommendedMovieIds = restTemplate.getForObject(ML_MODEL_URL + "/" + userId, int[].class);
//        return movieRepository.findByIdIn(recommendedMovieIds);
//    }
    
    public List<Movie> getRecommendations(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        
        // Create the URL dynamically using the userId
        String url = ML_MODEL_URL + "/" + userId;
        
        // Fetch the recommendations as a ResponseEntity to handle errors more gracefully
        ResponseEntity<int[]> response = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                null, 
                int[].class
        );
        
        // Extract the body from the ResponseEntity
        int[] recommendedMovieIds = response.getBody();
        
        // If the response is not empty, fetch the corresponding movies from the repository
        if (recommendedMovieIds != null && recommendedMovieIds.length > 0) {
            return movieRepository.findByIdIn(recommendedMovieIds);
        }
        
        // Return an empty list if no recommendations are found
        return Collections.emptyList();
    }
    
    public List<Question> getAllProgrammingQuestions() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(ML_MODEL_URL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // ✅ Parse JSON response into a List<Question>
            return objectMapper.readValue(response.getBody(), new TypeReference<List<Question>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse questions from Flask service", e);
        }
    }
    



}

