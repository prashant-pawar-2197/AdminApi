package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IMovieService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	
	@Autowired
	private IMovieService movieService;
	
	@GetMapping("/nowShowing")
	public ResponseEntity<?> getNowShowing(){
		return new ResponseEntity<>(movieService.getLatestMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/getMovie/{imdbId}")
	public ResponseEntity<?> getMovie(@PathVariable String imdbId){
		return new ResponseEntity<>(movieService.getMovie(imdbId), HttpStatus.OK);
	}
	
}
