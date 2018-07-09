package br.com.academia.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.MelhoresMediasAluno;
import br.com.academia.utils.MetodosPublicos;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GeraGraficoPeriodoControle {

	    @FXML private CategoryAxis larguraGrafico;
	    @FXML private NumberAxis alturaGrafico;
	    @FXML private BarChart<String, Number> Grafico;
	    
	    public static List<MelhoresMediasAluno> dados = new ArrayList<>();
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public void initialize() {
	    	System.out.println("entrei no Initialize");
	    	System.out.println(dados.toString());
	    	XYChart.Series serie1 = new XYChart.Series<String, Number>();
	    	XYChart.Series serie2 = new XYChart.Series<String, Number>();
	    	XYChart.Series serie3 = new XYChart.Series<String, Number>();
	    	XYChart.Series serie4 = new XYChart.Series<String, Number>();
	    	XYChart.Series serie5 = new XYChart.Series<String, Number>();
	    	
	    	for(MelhoresMediasAluno dado : dados) {
		    	serie1.getData().add(new XYChart.Data<String, Number>("Passos", dado.getMaiorNumeroPassos()));
		    	serie1.setName("Passos");
		    	serie2.getData().add(new XYChart.Data<String, Number>("Calorias", dado.getMaiorNumeroCaloriasPerdias()));
		    	serie2.setName("Calorias Perdidas");
		    	serie3.getData().add(new XYChart.Data<String, Number>("Duração", MetodosPublicos.converteTimeMinutios(dado.getMaiorDuracao())));
		    	serie3.setName("Duração");
		    	serie4.getData().add(new XYChart.Data<String, Number>("Velocidade", dado.getMaiorVelocidade()*1000));
		    	serie4.setName("Velocidade");
		    	serie5.getData().add(new XYChart.Data<String, Number>("Distancia", dado.getMaiorDistanciaPercorrida()*1000));
		    	serie5.setName("Distância");
	    	}
	    	Grafico.getData().addAll(serie1);
	    	Grafico.getData().addAll(serie2);
	    	Grafico.getData().addAll(serie3);
	    	Grafico.getData().addAll(serie4);
	    	Grafico.getData().addAll(serie5);
	    }

	
}//GeraGraficoPeriodoControle
