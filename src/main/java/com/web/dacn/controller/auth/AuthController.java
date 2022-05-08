package com.web.dacn.controller.auth;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.dacn.dto.user.UserLoginDto;
import com.web.dacn.entity.user.User;
import com.web.dacn.service.auth.UserService;



@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("login")
	public ModelAndView login(ModelMap model) {
		UserLoginDto user = new UserLoginDto();
		model.addAttribute("user", user);
		return new ModelAndView("authPage", model);
	}
	
	@PostMapping("login")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("user") UserLoginDto userLoginDto,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("authPage");
		}
		User user = userService.login(userLoginDto.getUsername(), userLoginDto.getPassword());
		if(user==null) {
			model.addAttribute("error", "Invalid username or email");
			return new ModelAndView("authPage", model);
		}
		session.setAttribute("user", user);
//		Object redirectUri= session.getAttribute("redirect-uri");
//		if(redirectUri!=null) {
//			session.removeAttribute("redirect-uri");
//			return new ModelAndView("redirect:"+redirectUri);
//		}
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("logout")
	public ModelAndView logout(ModelMap model) {
		session.removeAttribute("user");
		return new ModelAndView("redirect:/");
	}
	
}
