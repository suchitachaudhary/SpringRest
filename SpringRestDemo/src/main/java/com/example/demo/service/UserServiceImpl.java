package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements IuserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		System.out.println("in service");
		return userRepository.save(user);

	}

	@Override
	public List getUsers() {

		return userRepository.findAll(Sort.by(Direction.ASC, "userId"));
	}

	@Override
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getUserByAddress(String add) {
		return userRepository.findByAddress(add);
	}

	@Override
	public List<User> findByName(String Name) {
		return userRepository.findByName(Name);
	}

	@Override
	public void updateAddress(Long id, String address) {
		userRepository.updateAddress(id, address);
		
	}

}
