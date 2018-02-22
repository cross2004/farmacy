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
import com.example.model.Pacient;
import com.example.service.DoctorService;
import com.example.service.PacientService;
import com.example.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin/viewUsers", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listAllDoctors", doctorService.findAllDoctors());
		modelAndView.setViewName("admin/viewUsers");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("editUser", doctorService.findById(id));
		modelAndView.setViewName("admin/editUser");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/editUser", method = RequestMethod.POST)
	public String editUser(@Valid Doctor doctor, BindingResult bindingResult) {
		doctorService.editDoctor(doctor);
		return "redirect:viewUsers";
	}
	
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView();
		Doctor doctor = new Doctor();
		modelAndView.addObject("addDoctor", doctor);
		User user = userService.findUserByEmail("i@t.ro");
		modelAndView.addObject("addUserX", user);
		
		modelAndView.setViewName("admin/addUser");
		return modelAndView;

	}
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid Doctor doctor, BindingResult bindingResult,User user) {
		ModelAndView modelAndView = new ModelAndView();

		Doctor doctorExists = doctorService.findByCnp(doctor.getCnp());
		if (doctorExists != null) 
			modelAndView.setViewName("admin/addUser");
		else {
			User user2 = userService.findUserById(user.getId());
			doctorService.addDoctor(doctor, user2);
			modelAndView.setViewName("admin/viewUsers");
		}
		return modelAndView;
	}


}
