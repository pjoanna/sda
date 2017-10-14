package sda.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sda.spring.model.User;
import sda.spring.service.LoggedUsersService;
import sda.spring.service.UserDao;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserDao userService;
	
	@Autowired
	public LoggedUsersService loggedUsers;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		String errors = userService.register(user);
		if(StringUtils.isEmpty(errors)){
			loggedUsers.userLogin(user);
			return new ModelAndView("welcome", "user", user);
		}
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("message", errors);
		return mav;
	}
}