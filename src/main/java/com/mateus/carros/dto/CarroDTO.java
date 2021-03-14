package com.mateus.carros.dto;

import org.modelmapper.ModelMapper;

import com.mateus.carros.domain.Carro;

import lombok.Data;


@Data
public class CarroDTO { //Basicamente será um objeto resumido da classe carro
	
	
	private Long id;
	
	private String nome;
	
	private String tipo;
	
	public CarroDTO(Carro c) {
		id = c.getId();
		nome = c.getNome();
		tipo = c.getTipo();
	}
	
	public static CarroDTO create(Carro c) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(c, CarroDTO.class);
	}

}
