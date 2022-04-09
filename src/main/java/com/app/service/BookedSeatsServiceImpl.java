package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookedSeatRepository;

@Service
public class BookedSeatsServiceImpl implements IBookedSeatsService{
	@Autowired BookedSeatRepository bookSeatsRepo;
	
	@Override
	public List<String> getBookedSeats(int showId) {
		try {
			List<String> seats = bookSeatsRepo.getBookedSeats(showId);
			seats.forEach((s)->System.out.println(s));
			return seats;
		}catch(RuntimeException e) {
			throw new RuntimeException("Could not retrive booked seats");
		}
	}

}
