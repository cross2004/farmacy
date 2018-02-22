package com.example.service;

import com.example.model.User;
import com.example.model.Role;


public interface UserService {
	public User findUserByEmail(String email);
	public User findUserById(int id);
	
	public void saveUser(User user, Role role);
}
