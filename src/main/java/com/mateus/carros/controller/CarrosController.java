package com.mateus.carros.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.dto.CarroDTO;
import com.mateus.carros.service.CarrosService;

@RestController
@RequestMapping("/carros")  //Quer dizer que essa classe estará mapeada para /carros
public class CarrosController {
	
	@Autowired
	private CarrosService service;
	
	@GetMapping
	public ResponseEntity<Iterable<CarroDTO>> listarCarros() {
		return ResponseEntity.ok(service.getCarros());
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
	public ResponseEntity listarTipo(@PathVariable("tipo") String tipo){
		List<CarroDTO> carros = service.getTipo(tipo);
		return  carros.isEmpty() ?
				ResponseEntity.noContent().build() :
					ResponseEntity.ok(carros);
	}
	
	@PostMapping
	public ResponseEntity salvarCarro(@RequestBody Carro carro) { // @RequestBody transforma um Json em um objeto
		try {
			CarroDTO c = service.salvar(carro);
			URI location = getUri(c.getId());
			return ResponseEntity.created(location).build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity alterarCarro(@PathVariable("id") Long id, @RequestBody Carro carro) {
		CarroDTO c = service.alterar(carro, id);
		return c!= null ?
				ResponseEntity.ok(c):
					ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public void deletarCarro(@PathVariable("id") Long id) {
		service.deletar(id);
	}
}
