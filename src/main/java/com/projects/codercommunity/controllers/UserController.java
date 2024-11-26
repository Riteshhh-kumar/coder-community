package com.projects.codercommunity.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.codercommunity.services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> payload) {
		String user = userService.login(payload);
		return new ResponseEntity<String>(user, HttpStatus.OK);

	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Map<String,String> payload){
		String user = userService.register(payload);
		if(user!=null) {
			return new ResponseEntity<String>(user, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(user,HttpStatus.OK);
		}
	}
}
