package com.ignotocracia.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignotocracia.app.entity.Respuesta;
import com.ignotocracia.app.entity.User;
import com.ignotocracia.app.service.RespuestaService;
import com.ignotocracia.app.service.UserService;

@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin
public class RespuestaController {
	
	@Autowired
	private RespuestaService respuestaService;
	@CrossOrigin
	@GetMapping
	public List<Respuesta> readAll(){
		//Hay que convertir el iterable en una lista. false=secuencial en vez de paralelo
		//.stream(userService.findAll().spliterator(), false) para recorrer nuestro iterable
		// .collect(Collectors.toList()); lo pasa a lista
		 List<Respuesta> users= StreamSupport
				 .stream(respuestaService.findAll().spliterator(), false)
				 .collect(Collectors.toList());
		 return users;
	}

}
