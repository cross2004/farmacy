package com.example.service;

import com.example.model.User;

import java.util.List;

import com.example.model.Pacient;
import com.example.model.Role;


public interface UserService {
	public User findUserByEmail(String email);
	public User findUserById(int id);
	public List<User> findAll() ;
	public void saveUser(User user, Role role);
	public Role findRoleById(int id);
}
