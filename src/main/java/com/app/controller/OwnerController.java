package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Movie;
import com.app.pojos.Show;
import com.app.service.IScreenService;
import com.app.service.IMovieService;
import com.app.service.IShowService;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
@RequestMapping("/api/owner")
public class OwnerController {
	
	@Autowired 
	IShowService showService;
	@Autowired
	IMovieService movieService;	
	@Autowired
	IScreenService screenService;
	
	@PostMapping("/theatre/{theatreId}/movie/{movieId}/screen/{screenId}/addShow")
	public ResponseEntity<?> addShow(@RequestBody Show show, @PathVariable int screenId, @PathVariable int theatreId, @PathVariable String movieId){
		return ResponseEntity.ok(showService.addShow(show,screenId,theatreId,movieId));
		
	}
	
	@GetMapping("/theatre/{theatreId}/ongoingShow")
	public ResponseEntity<?> ongoingShow(@PathVariable int theatreId){
		return ResponseEntity.ok(showService.getAllShows(theatreId));
	
	@PostMapping("/updateScreen/{status}/{id}")
	public ResponseEntity<?> updateScreenStatuses(@PathVariable String status,@PathVariable int id){
		return new ResponseEntity<>(screenService.updateScreenStatus(status, id), HttpStatus.OK);
	}
	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie){
		return ResponseEntity.ok(movieService.addMovie(movie));
	}

}
