package br.com.academia.modelo;

import java.sql.Time;
import java.sql.Date;

public class ExercicioAerobico {

	private Long id;
	private String nomeUsuario;
	private String tipoExercicio;
	private Date data;
	private String tempo;
	private Time horaInicio;
	private Time horaFim;
	private Time duracao;
	private Double distancia;
	private Double caloriasPerdidas;
	private Integer passos;
	private Double velocidadeMedia;
	private Double velocidadeMaxima;
	private Time ritmoMedio;
	private Time ritmoMaximo;
	private Double menorElevacao;
	private Double maiorelevacao;
	private Ritmo ritmo;
	private Long idExercicio;
	private String emailAluno;
	
	public ExercicioAerobico() {
		super();
	}
	
	public ExercicioAerobico(String nomeUsuario, String tipoExercicio, Date data, String tempo, Time horaInicio,
			Time horaFim, Time duracao, Double distancia, Double caloriasPerdidas, Integer passos,
			Double velocidadeMedia, Double velocidadeMaxima, Time ritmoMedio, Time ritmoMaximo, Double menorElevacao,
			Double maiorelevacao, Ritmo ritmo, Long idExercicio, String emailAluno, Long id) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.tipoExercicio = tipoExercicio;
		this.data = data;
		this.tempo = tempo;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.duracao = duracao;
		this.distancia = distancia;
		this.caloriasPerdidas = caloriasPerdidas;
		this.passos = passos;
		this.velocidadeMedia = velocidadeMedia;
		this.velocidadeMaxima = velocidadeMaxima;
		this.ritmoMedio = ritmoMedio;
		this.ritmoMaximo = ritmoMaximo;
		this.menorElevacao = menorElevacao;
		this.maiorelevacao = maiorelevacao;
		this.ritmo = ritmo;
		this.idExercicio = idExercicio;
		this.emailAluno = emailAluno;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}

	public Time getDuracao() {
		return duracao;
	}

	public void setDuracao(Time duracao) {
		this.duracao = duracao;
	}
	
	public String getTipoExercicio() {
		return tipoExercicio;
	}
	
	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}
	
	public String getTempo() {
		return tempo;
	}
	
	public void setTempo(String tempo) {
		this.tempo = tempo;
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
	
	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	
	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	
	public Double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}
	
	public void setVelocidadeMaxima(Double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}
	
	public Time getRitmoMedio() {
		return ritmoMedio;
	}
	
	public void setRitmoMedio(Time ritmoMedio) {
		this.ritmoMedio = ritmoMedio;
	}
	
	public Time getRitmoMaximo() {
		return ritmoMaximo;
	}
	
	public void setRitmoMaximo(Time ritmoMaximo) {
		this.ritmoMaximo = ritmoMaximo;
	}
	
	public Double getMenorElevacao() {
		return menorElevacao;
	}
	
	public void setMenorElevacao(Double menorElevacao) {
		this.menorElevacao = menorElevacao;
	}
	
	public Double getMaiorelevacao() {
		return maiorelevacao;
	}
	
	public void setMaiorelevacao(Double maiorelevacao) {
		this.maiorelevacao = maiorelevacao;
	}

	public Ritmo getRitmo() {
		return ritmo;
	}

	public void setRitmo(Ritmo ritmo) {
		this.ritmo = ritmo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Long getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(Long idExercicio) {
		this.idExercicio = idExercicio;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
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
				"ExercicioAerobico [nomeUsuario=%s, tipoExercicio=%s, data=%s, tempo=%s, horaInicio=%s, horaFim=%s,"
				+ " duracao=%s, distancia=%s, caloriasPerdidas=%s, passos=%s, velocidadeMedia=%s, velocidadeMaxima=%s, ritmoMedio=%s, "
				+ "ritmoMaximo=%s, menorElevacao=%s, maiorelevacao=%s, ritmo=%s, id=%s]",
				nomeUsuario, tipoExercicio, data, tempo, horaInicio, horaFim, duracao, distancia, caloriasPerdidas,
				passos, velocidadeMedia, velocidadeMaxima, ritmoMedio, ritmoMaximo, menorElevacao, maiorelevacao,
				ritmo,id);
	}
	
}//exercicioAerobico
