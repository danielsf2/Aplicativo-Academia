package br.com.academia.modelo;

import java.sql.Time;

public class MelhoresMediasAluno {

	private Time maiorDuracao;
	private Double maiorDistanciaPercorrida;
	private Double maiorNumeroCaloriasPerdias;
	private Double maiorVelocidade;
	private Integer maiorNumeroPassos;
	
	public MelhoresMediasAluno() {
		super();
	}

	public MelhoresMediasAluno(Time maiorDuracao, Double maiorDistanciaPercorrida, Double maiorNumeroCaloriasPerdias,
			Double maiorVelocidade, Integer maiorNumeroPassos) {
		super();
		this.maiorDuracao = maiorDuracao;
		this.maiorDistanciaPercorrida = maiorDistanciaPercorrida;
		this.maiorNumeroCaloriasPerdias = maiorNumeroCaloriasPerdias;
		this.maiorVelocidade = maiorVelocidade;
		this.maiorNumeroPassos = maiorNumeroPassos;
	}

	public Time getMaiorDuracao() {
		return maiorDuracao;
	}

	public void setMaiorDuracao(Time maiorDuracao) {
		this.maiorDuracao = maiorDuracao;
	}

	public Double getMaiorDistanciaPercorrida() {
		return maiorDistanciaPercorrida;
	}

	public void setMaiorDistanciaPercorrida(Double maiorDistanciaPercorrida) {
		this.maiorDistanciaPercorrida = maiorDistanciaPercorrida;
	}

	public Double getMaiorNumeroCaloriasPerdias() {
		return maiorNumeroCaloriasPerdias;
	}

	public void setMaiorNumeroCaloriasPerdias(Double maiorNumeroCaloriasPerdias) {
		this.maiorNumeroCaloriasPerdias = maiorNumeroCaloriasPerdias;
	}

	public Double getMaiorVelocidade() {
		return maiorVelocidade;
	}

	public void setMaiorVelocidade(Double maiorVelocidade) {
		this.maiorVelocidade = maiorVelocidade;
	}

	public Integer getMaiorNumeroPassos() {
		return maiorNumeroPassos;
	}

	public void setMaiorNumeroPassos(Integer maiorNumeroPassos) {
		this.maiorNumeroPassos = maiorNumeroPassos;
	}

	@Override
	public String toString() {
		return String.format(
				"MelhoresMediasAluno [maiorDuracao=%s, maiorDistanciaPercorrida=%s, maiorNumeroCaloriasPerdias=%s, maiorVelocidade=%s, maiorNumeroPassos=%s]",
				maiorDuracao, maiorDistanciaPercorrida, maiorNumeroCaloriasPerdias, maiorVelocidade, maiorNumeroPassos);
	}
	
}//MelhoresMediasAluno
