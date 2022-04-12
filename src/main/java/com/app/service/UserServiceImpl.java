package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Address;
import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public User registerUser(User user) {
		try {
			return userRepo.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Email Already Exists");
		}
	}

	@Override
	public User loginUser(User user) {

		return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword())
				.orElseThrow(() -> new RuntimeException("User not valid"));
	}

	// -----------------------method for updating userDetails from profile
	// page----------------------------
	@Override
	public void updateUserDetails(String firstName, String lastName, String email, String phone, int userId) {
		// TODO Auto-generated method stub
		if (userRepo.existsById(userId)) {
			userRepo.updateUserDetails(firstName, lastName, email, phone, userId);
		} else
			throw new RuntimeException("User does not exist");
	}

	// ----------------------method to update the user
	// address----------------------------------------------
	@Override
	public void updateUserAddress(String city, String state, String pincode, int userId) {
		// TODO Auto-generated method stub
		if(addressRepo.existsById(userId)) {
			addressRepo.updateUserAddress(city, state, pincode, userId);
		}else {
			User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
			addressRepo.save(new Address(city, state, pincode, user));
		}
	}

	@Override
	public List<UserBookingHistoryDto> getUserBookingHistory(int userId) {
		System.out.println(userRepo.getAllSeatsNos(userId, 2));
		return userRepo.getUserBookingHistory(userId);
	}

}
