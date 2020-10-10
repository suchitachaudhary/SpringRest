 package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface IuserService {
	public User saveUser(User user);
	public List getUsers();
	public Optional<User> getUser(Long userId);
	public List<User> getUserByAddress(String userAddress);
	public List<User> findByName(String Name);
	public void updateAddress(Long id,String address);
}


