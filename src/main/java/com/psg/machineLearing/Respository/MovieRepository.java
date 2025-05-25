package com.psg.machineLearing.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psg.machineLearing.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query(nativeQuery=true , value="select * from movie")
	List<Movie> allMovie();
	
    List<Movie> findByIdIn(int[] ids);
}
