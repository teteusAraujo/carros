package com.mateus.carros.service;
		
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.dto.CarroDTO;
import com.mateus.carros.repository.CarroRepository;

@Service
public class CarrosService {
	
	@Autowired
	private CarroRepository repository;
	
	public List<CarroDTO> getCarros(){
		List<Carro> carros = repository.findAll();
		List<CarroDTO> list = carros.stream().map(c -> new CarroDTO(c)).collect(Collectors.toList());
		return list;
	}
			
	public Optional<CarroDTO> getCarro(Long id){
		return repository.findById(id).map(CarroDTO::create);
	}
	
	public List<CarroDTO> getTipo(String tipo){
		return repository.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
	}
	
	public CarroDTO salvar(Carro carro) {
		Assert.notNull(carro.getId(), "Não foi possivel inserir o novo Carro!");
		return CarroDTO.create(repository.save(carro));
	}
	
	public void deletar(Long id) {
	
		if(getCarro(id).isPresent()) {
		 repository.deleteById(id);
		}
	}



	public CarroDTO alterar(Carro carro, Long id) {
		Assert.notNull(carro.getId(), "Não foi possivel atualizar o Carro!");
		Optional<Carro> optional = repository.findById(id);
		if(optional.isPresent()) {
			Carro db = optional.get();
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo ());
			return  CarroDTO.create(db);
		} else {
			throw new RuntimeException("Não foi possivel atualizar o Registro!");
		}
	}



}
