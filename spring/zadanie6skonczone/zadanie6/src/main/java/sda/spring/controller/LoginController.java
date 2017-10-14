package sda.spring.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sda.spring.model.Login;
import sda.spring.model.User;
import sda.spring.service.LoggedUsersService;
import sda.spring.service.UserDao;

@Controller
public class LoginController {
	@Autowired
	UserDao userService;
	@Autowired
	LoggedUsersService loggedUsers;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		boolean loginSucessful = userService.validateUser(login);
		if (loginSucessful) {
			mav = new ModelAndView("welcome");
			User user = userService.getUser(login.getUsername());
			loggedUsers.userLogin(user);
			mav.addObject("user", user);
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
	
	@RequestMapping(value = "/logoutProcess", method = RequestMethod.POST)
	public ModelAndView logoutProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		loggedUsers.userLogout(user);
		return new ModelAndView("home");
	}
}
