package com.example.jwt.demo.Controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.demo.Models.User;
import com.example.jwt.demo.Services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8081/home/user
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		log.info("Getting Users...");
	System.out.println("Getting Users...");
	return userService.getAllUser();
	}
	
	@GetMapping("/test")
	public String test() {
		//log.info("test");
		System.out.println("test");
		return "Test";
	}
	
	
	@GetMapping()
	public String creatBasicUsers()
	{
		userService.saveUser(User.builder().userId(UUID.randomUUID().toString()).email("sayalee@gmail.com").name("Sayalee").password("abc").build());
		userService.saveUser(User.builder().userId(UUID.randomUUID().toString()).email("dhiraj@gmail.com").name("Dhiraj").password("abc").build());
		
		return "user got created";
	}
	
	@GetMapping("/currentUser")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
}

