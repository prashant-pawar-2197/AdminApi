package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookedSeatRepository;
import com.app.dao.ReservedSeatsRepository;
import com.app.pojos.ReservedSeats;

@Service
@Transactional
public class BookedSeatsServiceImpl implements IBookedSeatsService{
	@Autowired 
	BookedSeatRepository bookSeatsRepo;
	@Autowired
	ReservedSeatsRepository reserveRepo;
	
	@Override
	public List<String> getBookedSeats(int showId) {
		try {
			List<String> seats = bookSeatsRepo.getBookedSeats(showId);
			List<String> reserved = reserveRepo.getReservedSeats(showId);
			if (!reserved.isEmpty()) {
				seats.addAll(reserved);
			}
			return seats;
		}catch(RuntimeException e) {
			throw new RuntimeException("Could not retrive booked seats");
		}
	}
	
}
