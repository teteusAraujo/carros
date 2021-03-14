package com.mateus.carros.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mateus.carros.domain.Carro;

import lombok.Data;

@Entity
@Data
public class CarroDTO { //Basicamente será um objeto resumido da classe carro
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private String nome;
	
	private String tipo;
	
	public CarroDTO(Carro c) {
		id = c.getId();
		nome = c.getNome();
		tipo = c.getTipo();
	}
	

}
