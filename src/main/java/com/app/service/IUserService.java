package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	User registerUser(User user);
	<Optional>User loginUser(User user);
	//updating user details
	void updateUserDetails(String firstName, String lastName, String email, String phone, int userId);
	//updating user address
	void updateUserAddress(String city, String state, String pincode, int userId);
}
