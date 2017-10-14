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
public class HomeController {
	@Autowired
	LoggedUsersService loggedUsers;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("users", loggedUsers.getLoggedInUsers());
		return mav;
	}

}
