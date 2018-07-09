package br.com.academia.modelo;

public class Aluno {

	private Long id;
	private String nome;
	private String sexo;
	private Double altura;
	private Double peso;
	private String dataNascimento;
	private String email;
	
	public Aluno() {
		super();
	}
	
	public Aluno(Long id, String nome, String sexo, Double altura, Double peso, String dataNascimento, String email) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Double getAltura() {
		return altura;
	}
	
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Aluno [nome=%s, sexo=%s, altura=%s, peso=%s, dataNascimento=%s, email=%s]", nome, sexo,
				altura, peso, dataNascimento, email);
	}
	
}//aluno
