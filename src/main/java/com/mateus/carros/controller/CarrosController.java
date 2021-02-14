package com.mateus.carros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.dto.CarroDTO;
import com.mateus.carros.service.CarrosService;

@RestController
@RequestMapping("/carros")  //Quer dizer que essa classe estará mapeada para /carros
public class CarrosController {
	
	@Autowired
	private CarrosService service;
	
	@GetMapping
	public List<CarroDTO> listarCarros() {
		return service.getCarros();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity listarCarro(@PathVariable("id") Long id){
		Optional<CarroDTO> carro = service.getCarro(id);
		
		if(carro.isPresent()) {
			return ResponseEntity.ok(carro.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/tipo/{tipo}")
	public List<CarroDTO> listarTipo(@PathVariable("tipo") String tipo){
		return service.getTipo(tipo);
	}
	
	@PostMapping
	public Carro salvarCarro(@RequestBody Carro carro) { // @RequestBody transforma um Json em umobjeto
		return service.salvar(carro);
	}
	/*
	@PutMapping("/{id}")
	public Carro alterarCarro(@PathVariable("id") Long id, @RequestBody Carro carro) {
		return service.aletar(carro,id);
	}
	*/
	@DeleteMapping("/{id}")
	public void deletarCarro(@PathVariable("id") Long id) {
		service.deletar(id);
	}
}
