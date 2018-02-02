package com.example.controller;

import java.util.Arrays;
import java.util.Set;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.User;
import com.example.model.Role;
import com.example.model.Doctor;

import com.example.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();

		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, Role role) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user, role);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Bine ai venit " + user.getName() + " " + user.getLastName());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/doctor", method = RequestMethod.GET)
	public ModelAndView doctor() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Bine ai venit " + user.getName() + " " + user.getLastName());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("doctor/doctor");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/doctor", method = RequestMethod.POST)
	public ModelAndView doctorsActions(@Valid Doctor doctor,
			@RequestParam(value = "action", required = true) String action) {
		/*
		 * ModelAndView modelAndView = new ModelAndView(); if (action.equals("View")) {
		 * //modelAndView.addObject("doctor/viewSchedule");
		 * modelAndView.setViewName("doctor/viewSchedule");
		 * 
		 * // do something here }
		 * 
		 * if (action.equals("Edit")) {
		 * //modelAndView.addObject("doctor/editPacientData");
		 * modelAndView.setViewName("doctor/editPacientData");
		 * 
		 * // do another thing } if (action.equals("Add")) {
		 * //modelAndView.addObject("doctor/addNewPacient");
		 * modelAndView.setViewName("doctor/addNewPacient");
		 * 
		 * // do another thing } // model.addAttribute("attribute",
		 * "forwardWithForwardPrefix");
		 */
		ModelAndView modelAndView = new ModelAndView("redirect:/doctor/doctor.html");
		return modelAndView;
		
	}
}
