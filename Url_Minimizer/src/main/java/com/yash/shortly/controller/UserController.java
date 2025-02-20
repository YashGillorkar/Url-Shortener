package com.yash.shortly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.shortly.dto.UserDTO;
import com.yash.shortly.service.UserServiceI;

import jakarta.validation.Valid;

@RequestMapping("/api/user")
@RestController
public class UserController {

	@Autowired
	private UserServiceI userServiceI;

	@PostMapping("/register")
	public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userServiceI.registerUser(userDTO));
	}

}
