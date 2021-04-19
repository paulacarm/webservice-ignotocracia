package com.ignotocracia.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Tematica {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy="tematica")
	Set<Pregunta> listaPreguntas;

	public Tematica() {
		
	}

	public Tematica(@NotNull String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(Set<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	
	
}
