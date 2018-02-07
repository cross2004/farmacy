package com.example.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.User;
import com.example.model.Pacient;
import com.example.service.UserService;
import com.example.service.PacientService;

@Controller
public class DoctorController {
	@Autowired
	private UserService userService;
	@Autowired
	private PacientService pacientService;

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

	@RequestMapping(value = "/doctor/viewSchedule", method = RequestMethod.GET)
	public ModelAndView viewSchedule() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Bine ai venit " + user.getName() + " " + user.getLastName());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("doctor/viewSchedule");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/addNewPacient", method = RequestMethod.GET)
	public ModelAndView addNewPacient() {
		ModelAndView modelAndView = new ModelAndView();
		Pacient pacient = new Pacient();
		modelAndView.addObject("pacient", pacient);
		modelAndView.setViewName("doctor/addNewPacient");
		return modelAndView;

	}

	@RequestMapping(value = "/doctor/addNewPacient", method = RequestMethod.POST)
	public ModelAndView addNewPacient(@Valid Pacient pacient, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		Pacient pacientExists = pacientService.findPacientByCnp(pacient.getCnp());
		if (pacientExists != null) {
			bindingResult.rejectValue("cnp", "error.pacient",

					"There is already a pacient registered with the CNP provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("doctor/addNewPacient");
		} else {

			pacientService.savePacient(pacient);
			modelAndView.addObject("successMessage", "Pacient has been registered successfully");
			modelAndView.setViewName("doctor/addNewPacient");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/doctor/editPacientData", method = RequestMethod.GET)
	public ModelAndView editPacientData() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Bine ai venit " + user.getName() + " " + user.getLastName());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("doctor/editPacientData");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/viewPacients", method = RequestMethod.GET)
	public ModelAndView viewPacients() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listAll", pacientService.findAll());
		modelAndView.setViewName("doctor/viewPacients");

		return modelAndView;
	}

	@RequestMapping(value = "/doctor/viewVisitResults", method = RequestMethod.GET)
	public ModelAndView viewVisitResults(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("viewVisitResults", pacientService.viewVisitResults(id));
		modelAndView.setViewName("doctor/viewVisitResults");

		return modelAndView;
	}

	@RequestMapping(value = "/doctor/editPacient", method = RequestMethod.GET)
	public ModelAndView editPacient(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("editPacient", pacientService.editPacient(id));
		modelAndView.setViewName("doctor/editPacient");

		return modelAndView;
	}
	@RequestMapping(value = "/doctor/editPacient", method = RequestMethod.POST)
	public ModelAndView editPacient(@Valid Pacient pacient, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		pacientService.savePacient(pacient);
		modelAndView.setViewName("doctor/editPacient");
		return modelAndView;
	}
		
}
