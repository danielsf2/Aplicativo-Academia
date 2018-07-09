package br.com.academia.utils;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MetodosPublicos {

	/**
	 * Recebe como parâmetro a String com os dados recuperados do Arquivo texto e a parte do arquivo que se deseja recuperar
	 * com os paramentros início e fim, é recuperado a posição do arquivo e depois e retornado seu valor já sem os possíveis
	 * espaços no início e no final da String.
	 *  
	 * @param String
	 * @param String
	 * @param String
	 * @return String
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public static String recuperaString(String dadosCompletos, String valorInicio, String valorFim) {
		int ini = dadosCompletos.indexOf(valorInicio)+valorInicio.length();
		int fim = dadosCompletos.indexOf(valorFim, ini);
		String dado = dadosCompletos.substring(ini, fim).trim();
		return dado;
	}//recuperaString
	
	/**
	 * Recebe como parametro a String com os dados recuperados do Arquivo texto, recupera o nome do usuario
	 * e o retorna.
	 * @param String
	 * @return String
	 */
	public static String recuperaNome(String dadosCompletos) {
		String nome = MetodosPublicos.recuperaString(dadosCompletos, "Nome:", "Sexo:");
		return nome;
	}//recuperaNome
	
	public static void identificaTipoExercicio(String dados) {
		String aux = "Exercício:";
		String aux2 = "\n";
		String tipo = recuperaString(dados, aux, aux2);
		
		if(tipo.equalsIgnoreCase("corrida") || tipo.equalsIgnoreCase("caminhada")) {
			ManipulacaoExercicioAerobico.cadastraExercicioAerobico(tipo,dados);
		}
		else {
			ManipulacaoPraticaEsportiva.cadastraPraticaEsportiva(tipo, dados);
		}
	}//IdentificaTipoExercicio
	
	public static Date tranformaStringEmDate(String dataString) {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInserir=null;
		try {
			dataInserir = new Date(data.parse(dataString).getTime());
		} catch (ParseException formatoIncompativel) {
			JOptionPane.showMessageDialog(null, "Formato de Data Incompatível", "Erro", JOptionPane.ERROR_MESSAGE);
			formatoIncompativel.printStackTrace();
			System.exit(1);
		}
		return dataInserir;
	}
	
	public static Time converteStringEmTime(String tempo) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		java.util.Date data = null;
		Time hora = null;
		try {
			data = sdf.parse(tempo);
			hora = new Time(data.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return hora;
	}//ConverteStringEmTime
	
	public static String tranformaDateString(Date data) {
		SimpleDateFormat entrada = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat saida = new SimpleDateFormat("yyyy-MM-dd");
		String resultado=null;
		try {
			resultado = saida.format(entrada.parse(data.toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultado.trim();
	}
	
	public static Stage erro;
	
	public void telaDeErro() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/TelaDeErro.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/css/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Main Physical");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("../view/imagens/icone.png")));
			erro = stage;
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na Execução", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Stage sucesso;
	
	public void telaDeSucesso() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/TelaDeSucesso.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/css/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Main Physical");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("../view/imagens/icone.png")));
			sucesso = stage;
			stage.show();;
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na Execução", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void criaTela(String caminho) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(caminho));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/css/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Main Physical");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("../view/imagens/icone.png")));
			stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    		new MetodosPublicos().telaDeErro();
    	}
	}
	
	public static String converteTimeString(Time tempo) {
		Date hora = new Date(tempo.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String s = sdf.format(hora);
		return s;
	}//converteTimeString
	
	@SuppressWarnings("static-access")
	public static Integer converteTimeMinutios(Time tempo) {

		Calendar date = Calendar.getInstance();
		Date data = new Date(tempo.getTime());
		date.setTime(data);
		Integer minuto = date.HOUR*60;
		minuto += date.MINUTE;
		
		return minuto;
	}//converteTimeMinutos
	
}//MetodosPublicos
