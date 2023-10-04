package com.example.jwt.demo.Services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.jwt.demo.Models.User;

@Service
public class UserService {

//	private List<User> store=new ArrayList<>();
//	
//	public UserService() {
//		store.add(new User(UUID.randomUUID().toString(),name:"Sayalee", email:"sayalee@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),name:"Dhiraj", email:"dhiraj@gmail.com"));
//
//	}
//	public List<User> getUsers(){
//		return this.store;
//	}
	
	private Map<String, User> userRepository = new HashMap<>();
	
	public User saveUser(User user)
	{
		userRepository.put(user.getUserId(), user);
		return userRepository.get(user.getUserId());
	}


	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		
		for(Map.Entry<String, User> entry: userRepository.entrySet())
			users.add(entry.getValue());
			
		return users;
	}
}
