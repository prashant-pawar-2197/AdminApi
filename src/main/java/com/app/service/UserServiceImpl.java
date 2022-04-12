package com.app.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.SeatNumberForHistoryDto;
import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.User;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired 
	private UserRepository userRepo;
	@Override
	public User registerUser(User user) {
		try {
			return userRepo.save(user);
		}catch(DataIntegrityViolationException e) {
			throw new RuntimeException("Email Already Exists");
		}
	}

	@Override
	public User loginUser(User user) {
		
		return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElseThrow(()->new RuntimeException("User not valid"));
	}

	@Override
	public List<UserBookingHistoryDto> getUserBookingHistory(int userId) {
		List<UserBookingHistoryDto> bookingHistory = userRepo.getUserBookingHistory(userId);
		List<SeatNumberForHistoryDto> seatsList = userRepo.getAllSeatsNos(userId);
		for (int i = 0; i < bookingHistory.size(); i++) {
			for (int j = 0; j < seatsList.size(); j++) {
				if(bookingHistory.get(i).getBookingId()==seatsList.get(j).getBookingId()) {
					bookingHistory.get(i).setSeatNos(seatsList.get(j).getSeatNumber());
				}
			}
		}		
		return bookingHistory;

	}

}
