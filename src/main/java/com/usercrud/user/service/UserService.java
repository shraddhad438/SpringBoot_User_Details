package com.usercrud.user.service;

import com.usercrud.user.model.User;

public interface UserService {
	User saveUser(User user);
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
}

