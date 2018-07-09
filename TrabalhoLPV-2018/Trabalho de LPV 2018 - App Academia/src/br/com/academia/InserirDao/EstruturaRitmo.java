package br.com.academia.InserirDao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.academia.modelo.Ritmo;

public class EstruturaRitmo {

	public static Boolean parada = true;
	public static int ini,fim;
	String ritmoCompleto;
	
	/**
	 * Recebe o Identificador do Exercico Aerobico Correspondente, bem como uma String com os dados recuperados
	 * do Arquivo texto, trata os dados, e armazena seus campos em um Array do tipo ritmo e o retorna.
	 * @param String
	 * @return List<Ritmo>
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<Ritmo> criaEstruturaRitmo(String dadosCompletos) {
		Ritmo ritmo = new Ritmo();
		
		ritmo.setKm(recuperaPrimeiroKm(dadosCompletos));
		ritmo.setTempo(recuperaPrimeiroTempo(dadosCompletos));
		ritmo.setIdExercicio(EstruturaExercicioAerobico.extraiIdExercicio());
		
		List<Ritmo>ritmos = new ArrayList<Ritmo>();
		ritmos.add(ritmo);
		
		do {
			try {
				Ritmo rit = new Ritmo();
				if(dadosCompletos.charAt(fim)=='\n') {
					ini = fim;
					fim = dadosCompletos.indexOf("Km:",ini);
					String dados = dadosCompletos.substring(ini, fim);
					dados.replace('\n', ' ');
					dados = dados.replace(',', '.').trim();
					Double km = Double.parseDouble(dados);
					rit.setKm(km);
				}
				if(dadosCompletos.charAt(fim)=='K') {
					rit.setTempo(recuperaPrimeiroTempo(dadosCompletos));
					rit.setIdExercicio(EstruturaExercicioAerobico.extraiIdExercicio());
					ritmos.add(rit);
				}
			}
			catch(StringIndexOutOfBoundsException fimDaString) {
				parada=false;
			}
		}while(parada==true);

		return ritmos;
	}//criaEstruturaRitmo

	public Double recuperaPrimeiroKm(String dadosCompletos) {
		ini = dadosCompletos.indexOf("Ritmo ------")+12;
		fim = dadosCompletos.indexOf("Km:",ini);
		String dados = dadosCompletos.substring(ini, fim);
		dados.replace('\n', ' ');
		dados = dados.replace(',', '.').trim();
		Double km = Double.parseDouble(dados);
		return km;
	}//recuperaKm
		
	/**
	 * O método recebe como parâmetro uma String com os dados recuperados do arquivo texto e tem por
	 * finalidade recuperar o primeiro tempo de ritmo apresentado na estrutura repassada, para posteriomente
	 * posicionar um referencia da posição onde foi a ultima movimentação no conteúdo da String, recupera
	 * o primeiro tempo e o retorna. 
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	* @version 1.0		
	 */
	public Time recuperaPrimeiroTempo(String dadosCompletos) {
		ini = fim+3;
		fim = dadosCompletos.indexOf("\n",ini);
		String dados = dadosCompletos.substring(ini, fim);
		dados=dados.replace('”', ' ');
		dados=dados.replace('’', ':').trim();
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Time tempo = null;
		try {
			java.util.Date data = sdf.parse(dados);
			tempo = new Time(data.getTime());
		} catch (ParseException formatoIncompativel) {
			JOptionPane.showMessageDialog(null, "Formato de Hora Incompatível", "Erro", JOptionPane.ERROR_MESSAGE);
			formatoIncompativel.printStackTrace();
			System.exit(1);
		}
		return tempo;
	}//recuperaPrimeiroTempo
			
}//estruturaRitmo
