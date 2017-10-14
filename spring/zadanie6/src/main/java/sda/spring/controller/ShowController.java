package sda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sda.spring.model.LoggedUsers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShowController {
    @Autowired
    LoggedUsers loggedUsers;

    @RequestMapping(value = "/loggedUsersProcess", method = RequestMethod.GET)
    public ModelAndView showAllLoggedUsers() {
        ModelAndView modelAndView = new ModelAndView("loggedUsers");
        modelAndView.addObject("users", loggedUsers.getLoggedUsers());
        System.out.println("size" + loggedUsers.getLoggedUsers().size());
        return modelAndView;
    }
}
