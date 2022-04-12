package com.app.service;

import java.util.List;

import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.User;

public interface IUserService {
	User registerUser(User user);
	<Optional>User loginUser(User user);
	List<UserBookingHistoryDto> getUserBookingHistory(int userId);
}
