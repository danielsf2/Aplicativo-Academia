package br.com.academia.InserirDao;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.utils.MetodosPublicos;

public class EstruturaPraticaEsportiva {
	
	/**
	 * Recebe o nome do exercicio ja recuperado no método anterior e os dados recuperados do arquivo texto,
	 * é responsável por gerar e retornar um Objeto do tipo ExercicioAerobico.
	 * @param String
	 * @param String
	 * @return ExercicioAerobico
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public PraticaEsportiva criaEstruturaPraticaEsportiva(String nomeExercicio, String dadosCompletos) {
		PraticaEsportiva praticaEsportiva = new PraticaEsportiva();
		praticaEsportiva.setTipoExercicio(nomeExercicio);
		praticaEsportiva.setNomeUsuario(MetodosPublicos.recuperaNome(dadosCompletos));
		praticaEsportiva.setData(recuperaData(dadosCompletos));
		praticaEsportiva.setTempo(recuperaTempo(dadosCompletos));
		praticaEsportiva.setDuracao(recuperaDuracao(dadosCompletos));
		praticaEsportiva.setDistancia(recuperaDistancia(dadosCompletos));
		praticaEsportiva.setCaloriasPerdidas(recuperaCaloriasPerdidas(dadosCompletos));
		praticaEsportiva.setPassos(recuperaPassos(dadosCompletos));
		praticaEsportiva.setEmailAluno(EstruturaAluno.extraiIEmailAluno());
		
		return praticaEsportiva;
	}

	/**
	 * Recebe como parametro uma String com os dados recuperados do Arquivo de texto, recupera a data
	 * salva em uma string a transforma em um tipo compativel com Date para a futura inserção no banco de
	 * dados e retorna.
	 * 
	 * @param String
	 * @return Date
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Date recuperaData(String dadosCompletos) {
		String date = MetodosPublicos.recuperaString(dadosCompletos, "Data:", "\n");
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInserir=null;
		try {
			dataInserir = new Date(data.parse(date).getTime());
		} catch (ParseException formatoIncompativel) {
			JOptionPane.showMessageDialog(null, "Formato de Data Incompatível", "Erro", JOptionPane.ERROR_MESSAGE);
			formatoIncompativel.printStackTrace();
			System.exit(1);
		}
		return dataInserir;
	}//recuperaData
	
	/**
	 * Recebe como parametro uma String com os dados recuperados do Arquivo texto, recupera a variavel tempo
	 * da String que armazena o arquivo e retorna o dado.
	 *
	 * @param String
	 * @return String
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public String recuperaTempo(String dadosCompletos) {
		String tempo = MetodosPublicos.recuperaString(dadosCompletos, "Tempo:", "\n");
		return tempo;
	}//recuperaTempo
	
	/**
	 * Recebe como parâmetro uma String contendo os dados recuperados do Arquivo Texto, recupera nesta String a Duração,
	 * esse tipo String duração converte em um timo para armazenamento em banco de dados Time e retorna.
	 * 
	 * @param String
	 * @return	Time
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Time recuperaDuracao(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Duração:", "\n");
		SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss");//tipo do formato desejado
		Time duracao = null;
		try {
			java.util.Date data = date.parse(dados);//conversao de de String para Date
			duracao = new Time(data.getTime());//pegando date e transformando em Time
		} catch (ParseException formatoIncompativel) {
			JOptionPane.showMessageDialog(null, "Formato de Hora Incompatível", "Erro", JOptionPane.ERROR_MESSAGE);
			formatoIncompativel.printStackTrace();
			System.exit(1);
		}
		return duracao;
	}//recuperaDuracao
	
	/**
	 * Recebe como parametro uma String com o conteudo dos dados do Arquivo texto armazenada, recupera o valor do 
	 * campo distancia que esta armazenado como String altera o caracter ',' , converte o dado para Double e retorna o valor.
	 *
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaDistancia(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Distância:", "Km");
		dados = dados.replace(',' , '.');
		Double distancia = Double.parseDouble(dados);
		return distancia;
	}//recuperaDistancia
	
	/**
	 * Recebe como parâmetro uma String com os dados recuperados do Arquivo texto, recupera da String o campo caloriasPerdidas
	 * transforma o valor em Double e retorna o dado.
	 * 
	 * @param String
	 * @return	Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaCaloriasPerdidas(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "perdidas:", "Kcal");
		dados = dados.replace(',', '.');
		Double caloriasPerdidas = Double.parseDouble(dados);
		return caloriasPerdidas;
	}//recuperaCaloriasPerdidas
	
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
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Passos:", "\n");
		dados = dados.replace(".", "");
		Integer passos = Integer.parseInt(dados);
		return passos;
	}//recuperaPassos
	
}//EstruturaPraticaEsportiva
