package com.onetomany.rocket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.rocket.model.Usuario;
import com.onetomany.rocket.model.UsuarioLogin;
import com.onetomany.rocket.repository.UsuarioRepository;
import com.onetomany.rocket.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository repository;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autenticar(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		if(repository.findByEmail(usuario.getEmail()).isPresent()){
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> get(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Usuario>put(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.cadastrarUsuario(usuario));
	}
}
