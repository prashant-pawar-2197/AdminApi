package com.app.service;

import java.util.List;

import com.app.pojos.ReservedSeats;

public interface IBookedSeatsService {
	List<String> getBookedSeats(int showId);
	
}
