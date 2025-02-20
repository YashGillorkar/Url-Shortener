package com.yash.shortly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.shortly.dto.UserDTO;
import com.yash.shortly.entity.User;
import com.yash.shortly.repository.UserRepository;
import com.yash.shortly.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
			throw new RuntimeException("Username already exists");
		}

		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		user = userRepository.save(user);

		return new UserDTO(user.getId(), user.getUsername()); 
	}
}
