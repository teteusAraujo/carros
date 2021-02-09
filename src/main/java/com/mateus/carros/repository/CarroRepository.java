package com.mateus.carros.repository;

import org.springframework.data.repository.CrudRepository;

import com.mateus.carros.domain.Carro;

public interface CarroRepository extends CrudRepository<Carro, Long>{

}
