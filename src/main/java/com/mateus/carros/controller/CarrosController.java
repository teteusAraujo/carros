package com.mateus.carros.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/{id}")
	public Optional<Carro> listarCarro(@PathVariable("id") Long id){
		return service.getCarro(id);
	}
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> listarTipo(@PathVariable("tipo") String tipo){
		return service.getTipo(tipo);
	}
	
	@PostMapping
	public Carro salvarCarro(@RequestBody Carro carro) { // @RequestBody transforma um Json em objeto
		return service.salvar(carro);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCarro(@PathVariable("id") Long id) {
		service.deletar(id);
	}
}
