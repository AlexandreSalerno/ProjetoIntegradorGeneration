package com.onetomany.rocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.rocket.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByNomeContainingIgnoreCase(String nome);

	public List<Tema> findAllBySerie(int serie);
	
}
