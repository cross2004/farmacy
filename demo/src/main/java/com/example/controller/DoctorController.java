package com.example.controller;

import java.util.logging.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.User;
import com.example.model.Doctor;
import com.example.model.Pacient;
import com.example.model.Results;
import com.example.service.UserService;
import com.example.service.DoctorService;
import com.example.service.PacientService;
import com.example.service.ScheduleService;

@Controller
public class DoctorController {
	@Autowired
	private UserService userService;
	@Autowired
	private PacientService pacientService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private DoctorService doctorService;
	private static final Logger logger = Logger.getLogger(DoctorController.class.getName());

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

	@RequestMapping(value = "/doctor/viewPacients", method = RequestMethod.GET)
	public ModelAndView viewPacients() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listAll", pacientService.findAll());
		modelAndView.setViewName("doctor/viewPacients");
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
	public String addNewPacient(@Valid Pacient pacient, BindingResult bindingResult) {
		// ModelAndView modelAndView = new ModelAndView();

		Pacient pacientExists = pacientService.findPacientByCnp(pacient.getCnp());
		if (pacientExists != null) {
			bindingResult.rejectValue("cnp", "error.pacient",

					"There is already a pacient registered with the CNP provided");
		}
		if (bindingResult.hasErrors()) {
			// modelAndView.setViewName("doctor/addNewPacient");
			return "redirect:addNewPacient";
		} else {

			pacientService.savePacient(pacient);
			// modelAndView.addObject("successMessage", "Pacient has been registered
			// successfully");
			// modelAndView.setViewName("doctor/viewPacients");
			return "redirect:viewPacients";
		}
		// return modelAndView;
		// return "redirect:viewPacients";
	}

	@RequestMapping(value = "/doctor/editPacient", method = RequestMethod.GET)
	public ModelAndView editPacient(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("editPacient", pacientService.editPacient(id));
		modelAndView.setViewName("doctor/editPacient");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/editPacient", method = RequestMethod.POST)
	public String editPacient(@Valid Pacient pacient, BindingResult bindingResult) {
		pacientService.savePacient(pacient);
		return "redirect:viewPacients";
	}

	@RequestMapping(value = "/doctor/addVisitResult", method = RequestMethod.GET)
	public ModelAndView addVisitResult(int id) {
		ModelAndView modelAndView = new ModelAndView();

		Pacient pacient = pacientService.findById(id);
		modelAndView.addObject("pacientTR", pacient);

		Results result = new Results();
		modelAndView.addObject("addVisitResult", result);

		modelAndView.setViewName("doctor/addVisitResult");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/addVisitResult", method = RequestMethod.POST)
	public String addVisitResult(@Valid Pacient pacient, @Valid Results result) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		Doctor doctorNew = doctorService.findDoctorFromUser(user);
		if (doctorNew != null) {
			result.setDoctorRes(doctorNew);
			pacientService.saveResult(pacient.getId(), result);
		} else
			logger.info("User has no doctor attached!");

		return "redirect:viewPacients";
	}

	@RequestMapping(value = "/doctor/viewVisitResults", method = RequestMethod.GET)
	public ModelAndView viewScheduleAll(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("viewVisitResults", pacientService.viewVisitResults2(id));
		modelAndView.setViewName("doctor/viewVisitResults");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/viewSchedule", method = RequestMethod.GET)
	public ModelAndView viewSchedule() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("schAll", scheduleService.findAll());
		modelAndView.addObject("allPacients", pacientService.findAll());
		modelAndView.setViewName("doctor/viewSchedule");
		return modelAndView;
	}
}
