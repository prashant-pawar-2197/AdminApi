package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {
	@Autowired
	private IUserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> LoginSuccess(@RequestBody User login) {
			return ResponseEntity.ok(userService.loginUser(login));
		
		
	}
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@RequestBody @Valid User user){
			return ResponseEntity.ok(userService.registerUser(user));
		
	}
}
