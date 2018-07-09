package br.com.academia.controle;

import java.sql.Date;
import java.sql.Time;

import br.com.academia.utils.MetodosPublicos;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PesquisaMelhoresMediasAlunoTelaControle {

    @FXML private Text maiorDistancia;
    @FXML private Text maiorCalorias;
    @FXML private Text dataMaiorCaloria;
    @FXML private Text maiorPassos;
    @FXML private Text dataMaiorPassos;
    @FXML private Text maiorDuracao;
    @FXML private Text dataMaiorDistancia;
    @FXML private Text maiorVelocidade;
    @FXML private Text dataMaiorDuracao;
    @FXML private Text dataMaiorVelocidade;
	
	static Double MaiorVelocidade;
	static Date DataMaiorVelocidade;
	static Double MaiorDistancia;
	static Date DataMaiorDistancia;
	static Integer MaiorPassos;
	static Date DataMaiorPassos;
	static Double MaiorCaloriasPerdidas;
	static Date DataMaiorCaloriasPerdidas;
	static Time MaiorDuracao;
	static Date DataMaiorDuracao;
	
	public void initialize() {
		
		maiorDistancia.setText(MaiorDistancia.toString());
		dataMaiorDistancia.setText(MetodosPublicos.tranformaDateString(DataMaiorDistancia));
		maiorCalorias.setText(MaiorCaloriasPerdidas.toString());
		dataMaiorCaloria.setText(MetodosPublicos.tranformaDateString(DataMaiorCaloriasPerdidas));
		maiorPassos.setText(MaiorPassos.toString());
		dataMaiorPassos.setText(MetodosPublicos.tranformaDateString(DataMaiorPassos));
		maiorVelocidade.setText(MaiorVelocidade.toString());
		dataMaiorVelocidade.setText(MetodosPublicos.tranformaDateString(DataMaiorVelocidade));
		maiorDuracao.setText(MetodosPublicos.converteTimeString(MaiorDuracao));
		dataMaiorDuracao.setText(MetodosPublicos.tranformaDateString(DataMaiorDuracao));
		
	}//initialize
	
}//PesquisaMelhoresMediasAlunoTelaControle
