package com.ignotocracia.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ignotocracia.app.entity.Pregunta;
import com.ignotocracia.app.repository.PreguntaRepository;


@Service
public class PreguntaServiceImpl implements PreguntaService{

	@Autowired
	private PreguntaRepository preguntaRepository;
	@Override
	public Iterable<Pregunta> findAll() {
		return this.preguntaRepository.findAll();
	}

	@Override
	public Page<Pregunta> findAll(Pageable pageable) {
		
		return  this.preguntaRepository.findAll(pageable);
	}

	@Override
	public Optional<Pregunta> findById(int id) {
	
		return this.preguntaRepository.findById(id);
	}

	@Override
	public Pregunta save(Pregunta pregunta) {
		
		return this.preguntaRepository.save(pregunta);
	}

	@Override
	public void deleteById(int id) {
		this.preguntaRepository.deleteById(id);
		
	}


}
