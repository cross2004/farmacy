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
import com.example.model.Pacient;
import com.example.model.Role;
import com.example.model.Doctor;

import com.example.service.PacientService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HelpDeskController {
	@Autowired
	private PacientService pacientService;

	
}
