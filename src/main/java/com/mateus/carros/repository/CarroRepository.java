package com.mateus.carros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.carros.domain.Carro;
import com.mateus.carros.dto.CarroDTO;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	List<Carro> findByTipo(String tipo);


}
