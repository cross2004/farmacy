package com.example.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Pacient;
import com.example.model.Results;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user, Role role) {
		User user1 = new User();
		user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user1.setActive(1);
		if ("USER".equals(role.getRole())) {
			Role userRole = roleRepository.findByRole("USER");
			user1.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		} else if ("ADMIN".equals(role.getRole())) {
			Role userRole = roleRepository.findByRole("ADMIN");
			user1.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		} else

		{
			Role userRole = roleRepository.findByRole("HELPDESK");
			user1.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		}
	user1.setEmail(user.getEmail());
	user1.setLastName(user.getLastName());
	user1.setName(user.getName());
	
	
		userRepository.save(user1);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Role findRoleById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	
	}