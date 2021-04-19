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

import com.ignotocracia.app.entity.Pregunta;
import com.ignotocracia.app.entity.User;
import com.ignotocracia.app.service.PreguntaService;
import com.ignotocracia.app.service.UserService;

@RestController
@RequestMapping("/api/preguntas")
@CrossOrigin
public class PreguntaController {
	
	@Autowired
	private PreguntaService preguntaService;
	
	//CRUD
	//Crear pregunta
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Pregunta> create(@RequestBody Pregunta pregunta){
	//Va a recibir en el cuerpo de la peticion un usuario y que lo guardaremos y lo devolveremos
		return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.save(pregunta));
	}
	
	//Leer todos las preguntas
	@CrossOrigin
	@GetMapping
	public List<Pregunta> readAll(){
		//Hay que convertir el iterable en una lista. false=secuencial en vez de paralelo
		//.stream(userService.findAll().spliterator(), false) para recorrer nuestro iterable
		// .collect(Collectors.toList()); lo pasa a lista
		List<Pregunta> preguntas= StreamSupport
				.stream(preguntaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
			 return preguntas;
		}
	
	

}

