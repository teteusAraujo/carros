package com.mateus.carros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.repository.CarroRepository;

@Service
public class CarrosService {
	
	@Autowired
	private CarroRepository repository;
	
	public Iterable<Carro> getCarros(){
		return repository.findAll();
	}

}
