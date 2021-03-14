package com.mateus.carros.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity // Quer dizer que vai ser uma tabela do nosso Banco de dados
@Data //Cria os contrutores, get e set e hashcod e equalsda classe
public class Carro {
	
	@Id //Significa que esse é a chave primaria da nossa tabela carro
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O id seja feito autoencremento só
	private Long id;
	
	private String nome;
	
	private String tipo;
	
	
	
}
