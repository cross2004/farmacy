package com.example.controller;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.User;
import com.example.model.Doctor;
import com.example.service.DoctorService;
import com.example.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UserService userService;

	private static final Logger logger = Logger.getLogger(AdminController.class.getName());
	static final String ADDUSER = "admin/addUser";

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
	//	if (bindingResult.hasErrors())
		//	logger.log(Level.SEVERE, "Edit not performed, doctor has errors!" + bindingResult.getAllErrors());
	//	else
			doctorService.editDoctor(doctor);
		return "redirect:viewUsers";
	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView();

		Doctor doctor = new Doctor();
		modelAndView.addObject("addDoctor", doctor);

		List<User> user = userService.findAll();
		modelAndView.addObject("addUserX", user);

		User userSel = new User();
		userSel.setId(1);
		modelAndView.addObject("userSel", userSel);

		modelAndView.setViewName(ADDUSER);
		return modelAndView;

	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid Doctor doctor, BindingResult bindingResult, User user) {
		ModelAndView modelAndView = new ModelAndView();
		Boolean exista = false;
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(ADDUSER);
		} else {
			Doctor doctorExists = doctorService.findByCnp(doctor.getCnp());
			if (doctorExists != null)
				modelAndView.setViewName(ADDUSER);
			else {
				exista = existaUserAsociat(user);
				if (exista.equals(false)) {
					User user2 = userService.findUserById(user.getId());
					doctorService.addDoctor(doctor, user2);
				}
			}
		
			modelAndView.setViewName("admin/viewUsers");
			
		}
		return modelAndView;
	}

	public Boolean existaUserAsociat(User user) {
		List<Doctor> listDoc = doctorService.findAllDoctors();
		for (Doctor d : listDoc) {
			Set<User> users = d.getUsers();
			for (User u : users)
				if (u.getId() == user.getId()) {
					return true;
				}
			
		}
		return false;
	}
}
