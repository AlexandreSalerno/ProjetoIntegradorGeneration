package com.onetomany.rocket.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onetomany.rocket.model.Usuario;
import com.onetomany.rocket.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		Optional<Usuario> user = repository.findByEmail(userEmail);
		user.orElseThrow(()-> new UsernameNotFoundException(userEmail + "not found"));
		return user.map(UserDetailsImpl::new).get();
		
	}

}
