package com.ignotocracia.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ignotocracia.app.entity.UsuarioLogro;
import com.ignotocracia.app.service.UsuarioLogroService;

@RestController
@RequestMapping("/api/logrosusuario")
@CrossOrigin
public class UsuarioLogroController {

	@Autowired
	UsuarioLogroService ulservice;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<UsuarioLogro> create(@RequestBody UsuarioLogro ul){
		//Va a recibir en el cuerpo de la peticion un usuario y que lo guardaremos y lo devolveremos
		return ResponseEntity.status(HttpStatus.CREATED).body(ulservice.save(ul));
	}
	
	
	
	@CrossOrigin
	@GetMapping
	public List<UsuarioLogro> readAll(){
		//Hay que convertir el iterable en una lista. false=secuencial en vez de paralelo
		//.stream(userService.findAll().spliterator(), false) para recorrer nuestro iterable
		// .collect(Collectors.toList()); lo pasa a lista
		 List<UsuarioLogro> logrosusuario= StreamSupport
				 .stream(ulservice.findAll().spliterator(), false)
				 .collect(Collectors.toList());
		 return logrosusuario;
	}
}
