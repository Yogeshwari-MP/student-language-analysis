package com.psg.machineLearing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.psg.machineLearing.Model.Movie;
import com.psg.machineLearing.Respository.MovieRepository;

@SpringBootApplication
public class MachineLearingApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MachineLearingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Test if data is being fetched
		System.out.println("Fetching all movies...");
		List<Movie> movies = movieRepository.allMovie(); // or use JPQL query
		movies.forEach(movie -> System.out.println(movie.getTitle()));
	}

}
