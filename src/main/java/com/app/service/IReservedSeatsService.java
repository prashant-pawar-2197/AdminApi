package com.app.service;

import java.util.List;

import com.app.pojos.ReservedSeats;

public interface IReservedSeatsService {
	List<String> getReservedSeats(int showId);
	List<ReservedSeats> reserveSeats(int showId,List<String> seats, int userId);
	
	List<ReservedSeats> getSeatsByUser(int userId);
	
	void deleteReservedSeatsofUser(int userId);
}
