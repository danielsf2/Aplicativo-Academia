package br.com.academia.modelo;

import java.sql.Time;
import java.sql.Date;

public class PraticaEsportiva {

	private Long id;
	private String tipoExercicio;
	private String nomeUsuario;
	private Date data;
	private String tempo;
	private Time duracao;
	private Double distancia;
	private Double caloriasPerdidas;
	private Integer passos;
	private String emailAluno;
	
	public PraticaEsportiva() {
		super();
	}
	
	public PraticaEsportiva(String tipoExercicio, String nomeUsuario, Date data, String tempo, Time duracao,
			Double distancia, Double caloriasPerdidas, Integer passos, String emailAluno, Long id) {
		this.tipoExercicio = tipoExercicio;
		this.nomeUsuario = nomeUsuario;
		this.data = data;
		this.tempo = tempo;
		this.duracao = duracao;
		this.distancia = distancia;
		this.caloriasPerdidas = caloriasPerdidas;
		this.passos = passos;
		this.emailAluno = emailAluno;
		this.id = id;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getTempo() {
		return tempo;
	}
	
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	public Time getDuracao() {
		return duracao;
	}
	
	public void setDuracao(Time duracao) {
		this.duracao = duracao;
	}
	
	public Double getDistancia() {
		return distancia;
	}
	
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	
	public Double getCaloriasPerdidas() {
		return caloriasPerdidas;
	}
	
	public void setCaloriasPerdidas(Double caloriasPerdidas) {
		this.caloriasPerdidas = caloriasPerdidas;
	}
	
	public Integer getPassos() {
		return passos;
	}
	
	public void setPassos(Integer passos) {
		this.passos = passos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format(
				"PraticaEsportiva [tipoExercicio=%s, nomeUsuario=%s, data=%s, tempo=%s, duracao=%s, distancia=%s, caloriasPerdidas=%s, "
				+ "passos=%s, emailAluno=%s, Id=%s]",
				tipoExercicio, nomeUsuario, data, tempo, duracao, distancia, caloriasPerdidas, passos, emailAluno,id);
	}

}//praticaEsportiva
