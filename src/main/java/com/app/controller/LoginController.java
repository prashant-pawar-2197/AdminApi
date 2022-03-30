package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Login;
import com.app.pojo.Register;
import com.app.repo.RegisterRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {
	@Autowired
	private RegisterRepository registerRepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> LoginSuccess(@RequestBody @Valid Login login) {
		try {
			return ResponseEntity.ok(registerRepo.findByEmailAndPassword(login.getEmail(), login.getPassword()).orElseThrow(()->new RuntimeException("User not found")));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		
	}
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@RequestBody @Valid Register user){
		try {
			return ResponseEntity.ok(registerRepo.save(user));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
