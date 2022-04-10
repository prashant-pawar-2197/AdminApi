package com.app.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ReservedSeatsRepository;
import com.app.dao.ShowRepository;
import com.app.dao.UserRepository;
import com.app.pojos.ReservedSeats;
import com.app.pojos.SeatStatus;
import com.app.pojos.Show;
import com.app.pojos.User;

@Service
@Transactional
public class ReservedSeatsServiceImpl implements IReservedSeatsService {
	@Autowired
	private ReservedSeatsRepository reserveRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ShowRepository showRepo;
	
	//a method to fetch reserved seats
		@Override
		public List<String> getReservedSeats(int showId) {
			List<String> seats = reserveRepo.getReservedSeats(showId);
			if (seats.isEmpty()) {
				return null;
			}
			return seats;
		}

		@Override
		public List<ReservedSeats> reserveSeats(int showId, List<String> seats, int userId) {
			User user;
			Show show;
			List<ReservedSeats> reservedSeats;
			if (userRepo.existsById(userId) && showRepo.existsById(showId)){
				try {
					try {
						user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("user did not found"));
						show = showRepo.findById(showId).orElseThrow(()->new RuntimeException("show did not found"));
					}catch(RuntimeException e) {
						throw new RuntimeException("Either user or show does not exists");
					}
					seats.forEach((s)->reserveRepo.save(new ReservedSeats(s,show,user,SeatStatus.RESERVED)));
				}catch(RuntimeException e) {
					throw new RuntimeException("seats are reserved");
				}	
			}
			
			return reserveRepo.getSeatsByUser(userId);
		}

		@Override
		public List<ReservedSeats> getSeatsByUser(int userId) {
			
			return reserveRepo.getSeatsByUser(userId);
		}

		@Override
		public void deleteReservedSeatsofUser(int userId) {
			try {
				reserveRepo.deleteReservedSeats(userId);
			}catch(RuntimeException e) {
				throw new RuntimeException("could not delete reserved seats");
			}
			
		}
}
