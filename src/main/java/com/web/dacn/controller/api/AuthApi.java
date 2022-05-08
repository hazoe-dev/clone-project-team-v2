package com.web.dacn.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dacn.entity.user.User;
import com.web.dacn.service.auth.UserService;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthApi {

	@Autowired
	private UserService userService;
	
	@GetMapping("validate-username")
	public String existUsername (@RequestParam String username) {
		if(userService.findByUsernameIgnoreCase(username).isPresent()) {
			return "Username existed!" ;
		}
		return "";
	}
	
	@GetMapping("get-id")
	public Long getId(String username) {
		Optional<User> user = userService.findByUsernameIgnoreCase(username);
		if(user.isPresent()) {
			return user.get().getId();
		}
		return null;
	}
}
