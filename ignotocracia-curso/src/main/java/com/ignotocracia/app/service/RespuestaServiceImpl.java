package com.ignotocracia.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ignotocracia.app.entity.Respuesta;
import com.ignotocracia.app.repository.RespuestaRepository;
import com.ignotocracia.app.repository.UserRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {
	
	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@Override
	public Iterable<Respuesta> findAll() {
		return respuestaRepository.findAll();
		
	}

	@Override
	public Page<Respuesta> findAll(Pageable pageable) {
		
		return respuestaRepository.findAll(pageable);
	}

	@Override
	public Optional<Respuesta> findById(Integer id) {
		
		return respuestaRepository.findById(id);
	}

	@Override
	public Respuesta save(Respuesta respuesta) {
		
		return respuestaRepository.save(respuesta);
	}

	@Override
	public void deleteById(Integer id) {
		this.respuestaRepository.deleteById(id);
		
	}

}
