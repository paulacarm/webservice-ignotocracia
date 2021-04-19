package com.ignotocracia.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ignotocracia.app.entity.Respuesta;


public interface RespuestaService  {
	
	//Devuelve un iterable. Este método  está en el JpaRepository
	public Iterable <Respuesta> findAll();
	//Devuele los usuarios con paginación
	public Page<Respuesta> findAll(Pageable pageable);
	
	public Optional<Respuesta> findById(Integer id);
	
	public Respuesta save(Respuesta respuesta);
	
	public void deleteById(Integer id);

	

}
