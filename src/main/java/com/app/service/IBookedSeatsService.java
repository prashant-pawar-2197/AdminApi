package com.app.service;

import java.util.List;

public interface IBookedSeatsService {
	List<String> getBookedSeats(int showId);
}
