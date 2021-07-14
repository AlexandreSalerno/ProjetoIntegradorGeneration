package com.onetomany.rocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.rocket.model.Comentario;

public interface ComentarioRepository extends JpaRepository <Comentario, Long>{

}
