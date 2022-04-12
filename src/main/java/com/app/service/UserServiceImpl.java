package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
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
		System.out.println(userRepo.getAllSeatsNos(userId, 2));
		return userRepo.getUserBookingHistory(userId);
	}

}
