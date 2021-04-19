package com.ignotocracia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignotocracia.app.entity.Respuesta;
import com.ignotocracia.app.entity.User;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta,Integer> {

}
