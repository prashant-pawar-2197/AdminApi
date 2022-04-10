package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.BookedSeats;

public interface BookedSeatRepository extends JpaRepository<BookedSeats, Integer>{
	//get the seats by show id
	
	@Query("select b.seatNumber from BookedSeats b where show.id=:showId")
	public List<String> getBookedSeats(@Param(value="showId") int showId);
	
}
