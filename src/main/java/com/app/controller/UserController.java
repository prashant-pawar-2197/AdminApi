package com.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IMovieService;
import com.app.service.IShowService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	
	@Autowired
	private IMovieService movieService;
	@Autowired
	private IShowService showService;
	
	
	@GetMapping("/nowShowing")
	public ResponseEntity<?> getNowShowing(){
		return new ResponseEntity<>(movieService.getLatestMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/getMovie/{imdbId}")
	public ResponseEntity<?> getMovie(@PathVariable String imdbId){
		return new ResponseEntity<>(movieService.getMovie(imdbId), HttpStatus.OK);
	}
	
	@GetMapping("/getShowsByCity/{city}/{movieId}")
	public ResponseEntity<?> getShowsByCity(@PathVariable String city, @PathVariable String movieId){
		System.out.println("In Get Mapping");
		return new ResponseEntity<>(showService.getShowByCity(city, movieId),HttpStatus.OK);
	}
	
	@GetMapping("/location/{location}/movie/{movieId}/getShowsByDate/{date}")
		public ResponseEntity<?> getShowsByDate(@PathVariable String location, @PathVariable String movieId,@PathVariable String date) {
		return new ResponseEntity<>(showService.getShowsByDate(LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd")), location, movieId),HttpStatus.OK);
	}
	
}
