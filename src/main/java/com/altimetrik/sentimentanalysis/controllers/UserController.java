package com.altimetrik.sentimentanalysis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.sentimentanalysis.models.User;
import com.altimetrik.sentimentanalysis.repositories.UserRepository;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;

	@PostMapping(path = "login")
	public boolean login(@RequestBody(required = false) User user) {		
		return true;
	}
	
	@GetMapping(path = "all")
	public List<User> getUsers() {		
		try {
			List<User> users = userRepo.findAll();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(path = "register")
	public boolean register(@RequestBody(required = false) User user) {		
		try {
			userRepo.saveAndFlush(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	@DeleteMapping(path = "delete/{username}")
	public boolean register(@PathVariable String username) {		
		try {
			userRepo.deleteByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
}
