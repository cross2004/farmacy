package com.example.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Doctor;
import com.example.model.Material;
import com.example.model.Pacient;
import com.example.model.Schedule;
import com.example.model.User;
import com.example.service.DoctorService;
import com.example.service.MaterialsService;
import com.example.service.PacientService;
import com.example.service.ScheduleService;
import com.example.service.UserService;

@Controller
public class HelpDeskController {
	@Autowired
	private PacientService pacientService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private MaterialsService materialsService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/helpdesk/viewScheduleAll", method = RequestMethod.GET)
	public ModelAndView viewScheduleAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("schAll", scheduleService.findAll());
		modelAndView.addObject("allPacients", pacientService.findAll());
		modelAndView.addObject("allDoctors", doctorService.findAllDoctors());
		modelAndView.setViewName("helpdesk/viewScheduleAll");
		return modelAndView;
	}

	@RequestMapping(value = "/helpdesk/viewMaterials", method = RequestMethod.GET)
	public ModelAndView viewMaterials() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("viewMaterials", materialsService.findAll());
		modelAndView.setViewName("helpdesk/viewMaterials");
		return modelAndView;
	}

	@RequestMapping(value = "/helpdesk/addAppointment", method = RequestMethod.GET)
	public ModelAndView addAppointment() {
		ModelAndView modelAndView = new ModelAndView();
		Schedule schedule = new Schedule();
		modelAndView.addObject("schedule", schedule);
		Doctor doctorSel = new Doctor();
		modelAndView.addObject("doctorSel", doctorSel);
		List<Doctor> doctors = doctorService.findAllDoctors();
		modelAndView.addObject("doctors", doctors);
		List<Pacient> pacients = pacientService.findAll();
		modelAndView.addObject("pacients", pacients);
		modelAndView.setViewName("helpdesk/addAppointment");
		return modelAndView;
	}

	public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
		return start1.before(end2) && start2.before(end1);
	}

	@RequestMapping(value = "/helpdesk/addAppointment", method = RequestMethod.POST)
	public String addAppointment(@Valid Schedule schedule, BindingResult bindingResult, Model model, Doctor doctor) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errMessage", "Appointment has null values");

			model.addAttribute("schedule", schedule);
			Doctor doctorSel = new Doctor();
			model.addAttribute("doctorSel", doctorSel);
			List<Doctor> doctors = doctorService.findAllDoctors();
			model.addAttribute("doctors", doctors);
			List<Pacient> pacients = pacientService.findAll();
			model.addAttribute("pacients", pacients);

			return ("helpdesk/addAppointment");
		} else {
			List<Schedule> schedule2 = scheduleService.findAll();
			boolean overlap = false;
			for (int i = 0; i < schedule2.size(); i++) {
				if ((schedule2.get(i).getStartTime() != null) && (isOverlapping(schedule2.get(i).getStartTime(),
						schedule2.get(i).getEndTime(), schedule.getStartTime(), schedule.getEndTime())))
					overlap = true;
			}
			if (!overlap)

				scheduleService.saveSchedule(schedule, doctor);
			return ("helpdesk/viewScheduleAll");
		}

	}

	@RequestMapping(value = "/helpdesk/addMaterials", method = RequestMethod.GET)
	public ModelAndView addMaterials() {
		ModelAndView modelAndView = new ModelAndView();
		Material material = new Material();
		modelAndView.addObject("addMat", material);
		modelAndView.setViewName("helpdesk/addMaterials");
		return modelAndView;
	}

	@RequestMapping(value = { "/helpdesk/addMaterials", "/helpdesk/editMaterials" }, method = RequestMethod.POST)
	public String addMaterial(@Valid Material material, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("addMat", material);
			model.addAttribute("errMessage", "User has null values");
			return "helpdesk/addMaterials";
		} else {
			materialsService.saveMaterial(material);
			return "helpdesk/viewMaterials";
		}
	}

	@RequestMapping(value = "/helpdesk/editMaterials", method = RequestMethod.GET)
	public ModelAndView editMaterial(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("editMaterial", materialsService.findById(id));
		modelAndView.setViewName("helpdesk/editMaterials");

		return modelAndView;
	}

	@RequestMapping(value = "/helpdesk/helpDesk", method = RequestMethod.GET)
	public ModelAndView helpDesk() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Bine ai venit " + user.getName() + " " + user.getLastName());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("helpdesk/helpDesk");

		// LocalDate dt = LocalDate.now().plusDays(30);
		// Date date1 = new Date();
		;

		List<Pacient> pacientNext = pacientService.findPacientsSuggestedDate();
		modelAndView.addObject("findPacientsSuggestedDate", pacientNext);
		return modelAndView;
	}

}
