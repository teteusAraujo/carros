package com.mateus.carros.service;
		
import java.util.Optional;

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
	
	public Optional<Carro> getCarro(Long id){
		return repository.findById(id);
	}
	public Iterable<Carro> getTipo(String tipo){
		return repository.findByTipo(tipo);
	}
	
	public Carro salvar(Carro carro) {
		return repository.save(carro);
	}
	
	public void deletar(Long id) {
		Optional<Carro> carro = getCarro(id);
		if(carro.isPresent()) {
		 repository.deleteById(id);
		}
	}

}
