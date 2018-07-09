package br.com.academia.modelo;

public class Usuario {

	private Long id;
	private Long senha;
	private String nome;
	private String papel;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Long id, Long senha, String nome, String papel) {
		this.id = id;
		this.senha = senha;
		this.nome = nome;
		this.papel = papel;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSenha() {
		return senha;
	}
	
	public void setSenha(Long senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPapel() {
		return papel;
	}
	
	public void setPapel(String papel) {
		this.papel = papel;
	}

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, senha=%s, nome=%s, papel=%s]", id, senha, nome, papel);
	}
	
}//usuario
