package br.com.academia.controle;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.MelhoresMediasAluno;
import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class GerarGraficoControle {

       @FXML private DatePicker FimPeriodoPesquisa;
	   @FXML private DatePicker InicioPeriodoPesquisa;
	   @FXML private TextField textoGeraGraficoPeriodo;
	   @FXML private TextField graficoTipoAtividade;
	  
	   @FXML
	   void AcaoBotaoGerarGraficoPeriodo(ActionEvent event) {
		   
		 	Calendar dataInicio = Calendar.getInstance();
			dataInicio.set(InicioPeriodoPesquisa.getValue().getYear(),
					InicioPeriodoPesquisa.getValue().getMonthValue()-1,InicioPeriodoPesquisa.getValue().getDayOfMonth());
			
			Calendar dataFim = Calendar.getInstance();
			dataFim.set(FimPeriodoPesquisa.getValue().getYear(),
					FimPeriodoPesquisa.getValue().getMonthValue()-1,FimPeriodoPesquisa.getValue().getDayOfMonth());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			
			Date inicio = MetodosPublicos.tranformaStringEmDate(sdf.format(dataInicio.getTime()));
			Date fim = MetodosPublicos.tranformaStringEmDate(sdf.format(dataFim.getTime()));

	    	String emailAluno = textoGeraGraficoPeriodo.getText();
	    	String nomeAtividade = graficoTipoAtividade.getText();
	    	
	    	if(nomeAtividade.equalsIgnoreCase("caminhada") || nomeAtividade.equalsIgnoreCase("corrida")) {
	    		GeraGraficoPeriodoControle.dados.clear();
	    		List<ExercicioAerobico> ex = new ExercicioAerobicoDAO().consultaExercicioEspecificoData(inicio, fim, emailAluno);
	    		for(ExercicioAerobico e : ex) {
	    			MelhoresMediasAluno dados = new MelhoresMediasAluno();
	    			dados.setMaiorDistanciaPercorrida(e.getDistancia());
	    			dados.setMaiorDuracao(e.getDuracao());
	    			dados.setMaiorNumeroCaloriasPerdias(e.getCaloriasPerdidas());
	    			dados.setMaiorNumeroPassos(e.getPassos());
	    			dados.setMaiorVelocidade(e.getVelocidadeMedia());
	    			GeraGraficoPeriodoControle.dados.add(dados);
	    		}
	    		new MetodosPublicos().criaTela("../view/GraficoDesempenhoPeriodoTelaa.fxml");
	    	}
	    	else {
	    		GeraGraficoPeriodoControle.dados.clear();
	    		List<PraticaEsportiva> pa = new PraticaEsportivaDAO().pesquisaEspecificaPraticaEsportivaData(inicio, fim, emailAluno);
	    		for(PraticaEsportiva p : pa) {
	    			MelhoresMediasAluno dados = new MelhoresMediasAluno();
	    			dados.setMaiorDistanciaPercorrida(p.getDistancia());
	    			dados.setMaiorDuracao(p.getDuracao());
	    			dados.setMaiorNumeroCaloriasPerdias(p.getCaloriasPerdidas());
	    			dados.setMaiorNumeroPassos(p.getPassos());
	    			dados.setMaiorVelocidade(0.0);
	    			GeraGraficoPeriodoControle.dados.add(dados);
	    		}
	    		new MetodosPublicos().criaTela("../view/GraficoDesempenhoPeriodoTelaa.fxml");
	    	}   
	   }//AcaoBotaoGerarGraficoPeriodo

}//GerarGraficoControle
