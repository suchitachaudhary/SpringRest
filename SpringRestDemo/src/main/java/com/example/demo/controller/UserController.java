package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GenericController;
import com.example.demo.entity.User;
import com.example.demo.service.IuserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController {

	Logger  log = LoggerFactory.getLogger("User management App");
	
	@Autowired
	IuserService userService;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		log.info("in controller save method");
		return userService.saveUser(user);
	}

	@PostMapping("/saves")
	public User save(HttpEntity<String> requestEntity) {
		System.out.println("in controller");
		String s = requestEntity.getBody();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		User user = gson.fromJson(s, User.class);
		Long id = user.getUserId();
		String name = user.getUserName();
		String add = user.getUserAddress();
		System.out.println("id " + id + " name " + name + " add " + add);
		return userService.saveUser(user);
	}

	@GetMapping
	public List getUsers() {
		log.info("in get method");
		return userService.getUsers();
	}

	@GetMapping("/{userId}")
	public Optional<User> getCourse(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@GetMapping("userByLoc/{userAddress}")
	public List<User> getUserByLocation(@PathVariable String userAddress) {
		return userService.getUserByAddress(userAddress);
	}
	@GetMapping("userByName/{userName}")
	public List<User> getUserByName(@PathVariable String userName) {
		return userService.findByName(userName);
	}
	@PutMapping("update/{id}/{address}")
	public String updateAddress(@PathVariable Long id,@PathVariable String address) {
		log.info(id+" id" +address+ " address");
		userService.updateAddress(id, address);
		return "User data updated";
		
	}
}