package com.example.controller;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.model.Doctor;
import com.example.model.User;
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
		// if (bindingResult.hasErrors())
		// logger.log(Level.SEVERE, "Edit not performed, doctor has errors!" +
		// bindingResult.getAllErrors());
		// else
		doctorService.editDoctor(doctor);
		return "redirect:viewUsers";
	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView();

		Doctor doctor = new Doctor();
		modelAndView.addObject("Doctor", doctor);

		List<User> user = userService.findAll();
		modelAndView.addObject("addUserX", user);

		User userSel = new User();
		userSel.setId(1);
		modelAndView.addObject("userSel", userSel);

		modelAndView.setViewName(ADDUSER);
		return modelAndView;

	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
	public String addUser(@Valid  Doctor doctor, BindingResult bindingResult, User user, Model model) {
		String modelAndView = "admin/viewUsers";
		String modelAndView1 = "admin/addUser";

		Boolean exista = false;
		if (bindingResult.hasErrors()) {
			User userSel = new User();
			userSel.setId(1);
			model.addAttribute("userSel", userSel);
			return modelAndView1;
		} else {
			Doctor doctorExists = doctorService.findByCnp(doctor.getCnp());
			if (doctorExists != null) {
				model.addAttribute("errMessage", "User has null values");
				return modelAndView1;
			}

			else {
				//don't use romanian ever!!!!
				exista = existaUserAsociat(user);
				if (exista.equals(false)) {
					User user2 = userService.findUserById(user.getId());
					doctorService.addDoctor(doctor, user2);
				} else {
					bindingResult.rejectValue("users", "error.user",
							"There is already a doctor linked to the user selected");
					if (bindingResult.hasErrors()) {
						return modelAndView1;
					}
				}
			}

			return modelAndView;

		}

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
