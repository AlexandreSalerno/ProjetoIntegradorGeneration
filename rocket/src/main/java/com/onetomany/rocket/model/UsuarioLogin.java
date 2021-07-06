package com.onetomany.rocket.model;

public class UsuarioLogin {
	
	private long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;
	
	private String foto;
	
	private int serie;
	
	private boolean instrutor;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public int getSerie() {
		return serie;
	}
	
	public void setSerie(int serie) {
		this.serie = serie;
	}

	public boolean isInstrutor() {
		return instrutor;
	}

	public void setInstrutor(boolean instrutor) {
		this.instrutor = instrutor;
	}
	
}
