package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Screen;
import com.app.pojos.Seat;
import com.app.pojos.Show;
import com.app.pojos.Theatre;
import com.app.service.ITheatreService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
		@Autowired
		private ITheatreService registerService;
		
		@PostMapping("/addTheatre")
		private ResponseEntity<?> addTheatre(@RequestBody @Valid Theatre theatre) {
			System.out.println("reached add theatre");
			registerService.addTheatre(theatre);
			return new ResponseEntity<>(theatre, HttpStatus.OK);
		}
		@DeleteMapping("/removeTheatre/{id}")
		private ResponseEntity<?> removeTheatre(@PathVariable int id)  {
			registerService.deleteTheatre(id);
			return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
		}
		
		@PostMapping("/theatre/{theatreId}/screen")
		private ResponseEntity<?> addScreen(@RequestBody @Valid Screen screen, @PathVariable int theatreId) {
			System.out.println("add screen");
			return new ResponseEntity<>(registerService.addScreen(screen, theatreId), HttpStatus.OK);
		}
		
		@PostMapping("/screen/{screenId}/seat")
		private ResponseEntity<?> addSeat(@RequestBody @Valid Seat seat,  @PathVariable int screenId) {
			System.out.println("add seat");
			return new ResponseEntity<>(registerService.addSeat(seat, screenId), HttpStatus.OK);
		}
		
		@PostMapping("/theatre/{theatreId}/show")
		private ResponseEntity<?> addShow(@RequestBody @Valid Show show,  @PathVariable int theatreId) {
			System.out.println("add show");
			return new ResponseEntity<>(registerService.addShow(show, theatreId), HttpStatus.OK);
		}
		
		
}
