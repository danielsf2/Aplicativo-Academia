package br.com.academia.modelo;

import java.sql.Time;
import java.util.ArrayList;

public class Ritmo {

	private Long idExercicio;
	private Double km;
	private Time tempo;
	
	public Double getKm() {
		return km;
	}
	
	public void setKm(Double km) {
		this.km = km;
	}
	
	public Time getTempo() {
		return tempo;
	}
	
	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}
	
	public ArrayList<Ritmo> criaArrayRitmo(){
		ArrayList<Ritmo> ritmo = new ArrayList<Ritmo>();
		return ritmo;
	}

	public Long getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(Long idExercicio) {
		this.idExercicio = idExercicio;
	}

	@Override
	public String toString() {
		return String.format("Ritmo [idExercicio=%s, km=%s, tempo=%s]", idExercicio, km, tempo);
	}
	
}//ritmo
