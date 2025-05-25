package com.psg.machineLearing.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.psg.machineLearing.Model.Movie;
import com.psg.machineLearing.Service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Fetch all movies
    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Fetch recommendations for a user
    @GetMapping("/recommendations/{userId}")
    public List<Movie> getRecommendations(@PathVariable int userId) {
        return movieService.getRecommendations(userId);
    }
    
   
}

