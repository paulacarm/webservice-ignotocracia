package com.ignotocracia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignotocracia.app.entity.Pregunta;


@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Integer> {
	
}
