package com.onetomany.rocket.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.onetomany.rocket.model.Usuario;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String userUsuario;
	private String userPassword;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl (Usuario user) {
		this.userUsuario = user.getEmail();
		this.userPassword = user.getSenha();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
