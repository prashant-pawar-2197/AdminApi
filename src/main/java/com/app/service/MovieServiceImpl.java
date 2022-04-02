package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MovieRepository;
import com.app.pojos.Movie;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}

}
