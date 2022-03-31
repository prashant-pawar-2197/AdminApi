package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	public User registerUser(User user);
	public <Optional>User loginUser(User user);
}
