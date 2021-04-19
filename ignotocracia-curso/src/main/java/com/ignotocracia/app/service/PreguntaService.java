package com.ignotocracia.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ignotocracia.app.entity.Pregunta;


public interface PreguntaService {
	
	public Iterable <Pregunta> findAll();

	public Page<Pregunta> findAll(Pageable pageable);
	
	public Optional<Pregunta> findById(int id);
	
	public Pregunta save(Pregunta pregunta);
	
	public void deleteById(int id);

}
