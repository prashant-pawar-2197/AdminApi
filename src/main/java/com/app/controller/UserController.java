package com.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookAndPayDto;
import com.app.pojos.Booking;
import com.app.service.IBookedSeatsService;
import com.app.service.IMovieService;
import com.app.service.IPaymentService;
import com.app.service.IReservedSeatsService;
import com.app.service.IShowService;
import com.app.service.ITheatreService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	
	@Autowired
	private IMovieService movieService;
	@Autowired
	private IShowService showService;
	@Autowired
	private ITheatreService theatreService;
	@Autowired
	private IBookedSeatsService bookSeatsService;
	@Autowired
	private IReservedSeatsService reservedSeatsService;
	@Autowired
	private IPaymentService payService;
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
	
	@GetMapping("/theatre/{theatreId}/date/{date}")
		public ResponseEntity<?> getAllShowsByTheatre(@PathVariable int theatreId,@PathVariable String date){
		return new ResponseEntity<>(showService.getAllShowsByTheatre(theatreId,LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"))),HttpStatus.OK);
	}
	
	@GetMapping("/theatre/{theatreId}")
		public ResponseEntity<?> getTheatreDetailsById(@PathVariable int theatreId){
		return new ResponseEntity<>(theatreService.getTheatreById(theatreId),HttpStatus.OK);
	}
	
	@GetMapping("/getBookedSeats/{showId}")
	public ResponseEntity<?> getBookedSeats(@PathVariable int showId){
		return new ResponseEntity<>(bookSeatsService.getBookedSeats(showId), HttpStatus.OK);
	}
	@GetMapping("/booking/ticket/{showId}")
	public ResponseEntity<?> getBookingTicketDetails(@PathVariable int showId){
		return new ResponseEntity<>(showService.getShowDetailsByShowId(showId),HttpStatus.OK);
	}
	
	@GetMapping("/imdbId/{showId}")
	public ResponseEntity<?> getImdbIdFromShowID(@PathVariable int showId){
		return new ResponseEntity<>(showService.getImdbIdFromShowId(showId),HttpStatus.OK);
	}
	
	@PostMapping("/{userId}/reservedSeats/{showId}")
	public ResponseEntity<?> getReservedSeats(@RequestBody List<String> checkedSeats,@PathVariable int userId,@PathVariable int showId){
		return new ResponseEntity<>(reservedSeatsService.reserveSeats(showId, checkedSeats, userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}/deleteReservedSeats")
	public ResponseEntity<?> deleteReserveSeats(@PathVariable int userId){
		reservedSeatsService.deleteReservedSeatsofUser(userId);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/bookAndPay")
	public ResponseEntity<?> bookAndPay(@RequestBody BookAndPayDto bookAndPay){
		Booking booking = bookSeatsService.bookSeats(bookAndPay.getUser(), bookAndPay.getAmount());
		return new ResponseEntity<>(payService.makePayment(bookAndPay, booking),HttpStatus.OK);
	}
	
}
