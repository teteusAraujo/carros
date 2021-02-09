package com.mateus.carros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.service.CarrosService;

@RestController
@RequestMapping("/carros")
public class CarrosController {
	
	@Autowired
	private CarrosService service;
	
	@GetMapping
	public Iterable<Carro> listarCarros() {
		return service.getCarros();
	}

}
