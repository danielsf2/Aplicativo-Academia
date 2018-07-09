package br.com.academia.modelo;

import java.sql.Date;

public class Atividades {

	private String nomeAtividade;
	private Long id;
	private Date data;
	
	public Atividades() {
		super();
	}
	
	public Atividades(String nome, Long id, Date data) {
		this.nomeAtividade = nome;
		this.id = id;
		this.data = data;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Atividades [nomeAtividade=%s, id=%s, data=%s]", nomeAtividade, id, data);
	}

}//Atividades
