package br.com.academia.InserirDao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JOptionPane;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.utils.MetodosPublicos;

public class EstruturaExercicioAerobico {
	
	private static Long id;

	/**
	 * Recebe o nome do exercicio ja recuperado no método anterior e os dados recuperados do arquivo texto,
	 * é responsável por gerar e retornar um Objeto do tipo ExercicioAerobico.
	 * @param String
	 * @param String
	 * @return ExercicioAerobico
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public ExercicioAerobico criaEstruturaExercicioAerobico(String nomeExercicio, String dadosCompletos) {
		ExercicioAerobico exercicio = new ExercicioAerobico();
		exercicio.setTipoExercicio(nomeExercicio);
		exercicio.setNomeUsuario(MetodosPublicos.recuperaNome(dadosCompletos));
		exercicio.setData(new EstruturaPraticaEsportiva().recuperaData(dadosCompletos));
		exercicio.setTempo(new EstruturaPraticaEsportiva().recuperaTempo(dadosCompletos));
		exercicio.setDuracao(new EstruturaPraticaEsportiva().recuperaDuracao(dadosCompletos));
		exercicio.setDistancia(new EstruturaPraticaEsportiva().recuperaDistancia(dadosCompletos));
		exercicio.setCaloriasPerdidas(new EstruturaPraticaEsportiva().recuperaCaloriasPerdidas(dadosCompletos));
		exercicio.setPassos(recuperaPassos(dadosCompletos));
		exercicio.setVelocidadeMedia(recuperaVelocidadeMedia(dadosCompletos));
		exercicio.setVelocidadeMaxima(recuperaVelocidadeMaxima(dadosCompletos));
		exercicio.setRitmoMedio(recuperaRitmoMedio(dadosCompletos));
		exercicio.setRitmoMaximo(recuperaRitmoMaximo(dadosCompletos));
		exercicio.setMenorElevacao(recuperaMenorElevacao(dadosCompletos));
		exercicio.setMaiorelevacao(recuperaMaiorElevacao(dadosCompletos));
		exercicio.setIdExercicio(geraIdExercicio());
		id = exercicio.getIdExercicio();
		exercicio.setEmailAluno(EstruturaAluno.extraiIEmailAluno());
		
		return exercicio;
	}
	
	/**
	 * Recebe como parametro uma String com todos os dados recuperados do arquivo texto, recupera deste arquivo
	 * o numero de passos e retorna o valor.
	 * 
	 * @param String
	 * @return String
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Integer recuperaPassos(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Passos:", "Velocidade média:");
		dados = dados.replace(".", "");
		Integer passos = Integer.parseInt(dados);
		return passos;
	}//recuperaPassos
	
	/**
	 * Recebe como parâmetro uma String com os dados recuperados do Arquivo texto , deste arquivo é recuperado
	 * a Velocidade Média a qual é retornada.
	 * 
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaVelocidadeMedia(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "média:", "Km/h");
		dados = dados.replace(',' , '.');
		Double velocidadeMedia = Double.parseDouble(dados);
		return velocidadeMedia;
	}//recuperaVelocidadeMedia
	
	/**
	 *  Recebe como parâmetro uma String com os dados recuperados do Arquivo texto , deste arquivo é recuperado
	 * a Velocidade Máxima a qual é retornada.
	 * 
	 * @param String
	 * @return	Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaVelocidadeMaxima(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "máxima:", "Km/h");
		dados = dados.replace(',' , '.');
		Double velocidadeMaxima = Double.parseDouble(dados);
		return velocidadeMaxima;
	}//recuperaVelocidadeMaxima
	
	/**
	 * Recebe como Parâmetro uma String com os dados recuperados do Arquivo texto, extrai da mesma uma String
	 * contendo o ritmo médio, transforma essa String em um tipo compatível com Time e retorna;
	 * 
	 * @param String
	 * @return Time
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Time recuperaRitmoMedio(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "médio:", "/Km");
		dados = dados.replace('’' , ':');
		dados = dados.replace('”', ' ');
		dados = dados.trim();
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Time ritmoMedio = null;
		try {
			java.util.Date data = sdf.parse(dados);
			ritmoMedio = new Time(data.getTime());
		} catch (ParseException formatoIncompativel) {
			JOptionPane.showMessageDialog(null, "Formato de Hora Incompatível", "Erro", JOptionPane.ERROR_MESSAGE);
			formatoIncompativel.printStackTrace();
			System.exit(1);
		}
		return ritmoMedio;
	}//recuperaRitmoMedio
	
	
	/**
	 * Recebe como Parâmetro uma String com os dados recuperados do Arquivo texto, extrai da mesma uma String
	 * contendo o ritmo máximo, transforma essa String em um tipo compatível com Time e retorna;
	 * 
	 * @param String
	 * @return Time
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Time recuperaRitmoMaximo(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "máximo:", "/Km");
		dados = dados.replace('’' , ':');
		dados = dados.replace('”', ' ');
		dados = dados.trim();
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Time ritmoMaximo = null;
		try {
			java.util.Date data = sdf.parse(dados);
			ritmoMaximo = new Time(data.getTime());
		} catch (ParseException formatoIncompativel) {
			JOptionPane.showMessageDialog(null, "Formato de Hora Incompatível", "Erro", JOptionPane.ERROR_MESSAGE);
			formatoIncompativel.printStackTrace();
			System.exit(1);
		}
		return ritmoMaximo;
	}//recuperaRitmoMáximo
	
	/**
	 * Recebe como parâmetro uma String contendo os dados recuperados do Arquivo texto, recupera do mesmo
	 * a Menor Elevação a converte em Double e retorna o valor.
	 * 
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaMenorElevacao(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Menor elevação:", "m");
		dados = dados.replace(',', '.');
		Double menorElevacao = Double.parseDouble(dados);
		return menorElevacao;
	}//recuperaMenorElevacao
	
	/**
	 * Recebe como parâmetro uma String contendo os dados recuperados do Arquivo texto, recupera do mesmo
	 * a Maior Elevação a converte em Double e retorna o valor.
	 * 
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaMaiorElevacao(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Maior elevação:", "m");
		dados = dados.replace(',', '.');
		Double maiorElevacao = Double.parseDouble(dados);
		return maiorElevacao;
	}//recuperaMaiorElevacao
	
	public Long geraIdExercicio() {
		Random rand = new Random();
		Long id = rand.nextLong();
		if(id < 0)
			id = id*(-1);

		return id;
	}//geraidExercicio
	
	public static Long extraiIdExercicio() {
		return id;
	}
	
}//CriacaoEstruturas
