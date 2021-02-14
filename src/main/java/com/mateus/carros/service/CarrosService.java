package com.mateus.carros.service;
		
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.dto.CarroDTO;
import com.mateus.carros.repository.CarroRepository;

@Service
public class CarrosService {
	
	@Autowired
	private CarroRepository repository;
	
	public List<CarroDTO> getCarros(){
		List<Carro> carros = repository.findAll();
		List<CarroDTO> list = new ArrayList<>();
		for (Carro c : carros) {
			list.add(new CarroDTO(c));
		}
		return list;
	}
		
	
	public Optional<CarroDTO> getCarro(Long id){
		return repository.findById(id).map(CarroDTO::new);
	}
	public List<CarroDTO> getTipo(String tipo){
		return repository.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
	}
	
	public Carro salvar(Carro carro) {
		return repository.save(carro);
	}
	
	public void deletar(Long id) {
	
		if(getCarro(id).isPresent()) {
		 repository.deleteById(id);
		}
	}

	/*
	public CarroDTO aletar(Carro carro, Long id) {
		Optional<CarroDTO> optional = getCarro(id);
		if(optional.isPresent()) {
			Carro db = optional.get();
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			return repository.save(db);
		} else {
			throw new RuntimeException("Não foi possivel atualizar o Registro!");
		}
	}
*/
}
