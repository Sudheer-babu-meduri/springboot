package com.thymeleaf.thymeleaf01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymeleaf.thymeleaf01.repo.CarRepo;

@Controller
public class CarController {

	@Autowired
	CarRepo carrepo;
	
	
	@GetMapping("/hi")
	String getCarInfo(Model model) {
		
		model.addAttribute("allCarsInfo",carrepo.findAll());
		return "index";
	}
	
}
