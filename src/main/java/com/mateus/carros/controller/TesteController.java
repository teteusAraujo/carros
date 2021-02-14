package com.mateus.carros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@GetMapping
	public String olaMundo() {
		return "Realmente Spring Boot é facil";
	}
}
