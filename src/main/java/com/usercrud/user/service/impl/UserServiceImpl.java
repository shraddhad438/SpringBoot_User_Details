package com.usercrud.user.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usercrud.user.exception.ResourceNotFoundException;
import com.usercrud.user.model.User;
import com.usercrud.user.repository.UserRepository;
import com.usercrud.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

//service layer changes for create or save user
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new ResourceNotFoundException("User", "Id", id);
		}
	}

	@Override
	public User updateUser(User user, long id) {
		// TODO Auto-generated method stub
		// we need to check whether user with given id is exist in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("User", "Id", id));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAge(user.getAge());
		existingUser.setAddress(user.getAddress());
	
//		// save existing employee to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		// check whether a employee exist in a DB or not
		userRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}

}
