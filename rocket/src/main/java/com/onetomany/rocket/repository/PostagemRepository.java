package com.onetomany.rocket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.rocket.model.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long>{
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	
	public List<Postagem> findAllByConteudoContainingIgnoreCase(String conteudo);
	
	public List<Postagem> findAllByDate(Date date);
	
	public List<Postagem> findAllByTemaId(long id);

}
