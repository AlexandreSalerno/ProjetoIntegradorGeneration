package com.onetomany.rocket.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.onetomany.rocket.model.Usuario;
import com.onetomany.rocket.model.UsuarioLogin;
import com.onetomany.rocket.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarUsuario (Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
		
	}
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user){
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());
	
	
	if(usuario.isPresent()) {
		if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
		
			
			String auth = user.get().getEmail()+":"+ user.get().getSenha();
				byte[] encodedAuth = 
						Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
							String authHeader = "Basic " + new String (encodedAuth);
							
								user.get().setToken(authHeader);
								user.get().setId(usuario.get().getId());
								user.get().setNome(usuario.get().getNome());
								user.get().setEmail(usuario.get().getEmail());
								user.get().setSenha(usuario.get().getSenha());
								user.get().setFoto(usuario.get().getFoto());
								user.get().setInstrutor(usuario.get().isInstrutor());
								return user;
		}
	}
			return Optional.empty();
	
	
	
	}
}
