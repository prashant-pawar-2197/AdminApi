package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	User registerUser(User user);
	<Optional>User loginUser(User user);
}
