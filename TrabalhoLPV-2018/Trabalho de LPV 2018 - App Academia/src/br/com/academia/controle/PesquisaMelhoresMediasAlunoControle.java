package br.com.academia.controle;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.MelhoresMediasAlunoDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PesquisaMelhoresMediasAlunoControle {

    @FXML private TextField textoPesquisarAlunoPorPeriodo;

    @FXML
    void AcaoBotaoPesquisarMelhoresMedias(ActionEvent event) {
    	
    	Object novo = new MelhoresMediasAlunoDAO().MaiorDistanciaPercorrida(textoPesquisarAlunoPorPeriodo.getText());
    	if(novo instanceof ExercicioAerobico) {
    		ExercicioAerobico ex = new ExercicioAerobico();
    		ex = (ExercicioAerobico) novo;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorDistancia = ex.getDistancia();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorDistancia = ex.getData();
    	}
    	else {
    		PraticaEsportiva pa = new PraticaEsportiva();
    		pa = (PraticaEsportiva) novo;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorDistancia = pa.getDistancia();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorDistancia = pa.getData();
    	}
    	
    	Object novo1 = new MelhoresMediasAlunoDAO().MaiorNumeroCaloriasPerdidas(textoPesquisarAlunoPorPeriodo.getText());
    	if(novo1 instanceof ExercicioAerobico) {
    		ExercicioAerobico ex = new ExercicioAerobico();
    		ex = (ExercicioAerobico) novo1;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorPassos = ex.getPassos();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorPassos = ex.getData();
    	}
    	else {
    		PraticaEsportiva pa = new PraticaEsportiva();
    		pa = (PraticaEsportiva) novo1;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorPassos = pa.getPassos();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorPassos = pa.getData();
    	}
    	
    	Object novo2 = new MelhoresMediasAlunoDAO().MaiorDuracao(textoPesquisarAlunoPorPeriodo.getText());
    	if(novo2 instanceof ExercicioAerobico) {
    		ExercicioAerobico ex = new ExercicioAerobico();
    		ex = (ExercicioAerobico) novo2;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorDuracao = ex.getDuracao();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorDuracao = ex.getData();
    	}
    	else {
    		PraticaEsportiva pa = new PraticaEsportiva();
    		pa = (PraticaEsportiva) novo2;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorDuracao = pa.getDuracao();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorDuracao = pa.getData();
    	}
    	
    	Object novo3 = new MelhoresMediasAlunoDAO().MaiorNumeroCaloriasPerdidas(textoPesquisarAlunoPorPeriodo.getText());
    	if(novo3 instanceof ExercicioAerobico) {
    		ExercicioAerobico ex = new ExercicioAerobico();
    		ex = (ExercicioAerobico) novo3;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorCaloriasPerdidas = ex.getCaloriasPerdidas();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorCaloriasPerdidas = ex.getData();
    	}
    	else {
    		PraticaEsportiva pa = new PraticaEsportiva();
    		pa = (PraticaEsportiva) novo3;
    		PesquisaMelhoresMediasAlunoTelaControle.MaiorCaloriasPerdidas = pa.getCaloriasPerdidas();
    		PesquisaMelhoresMediasAlunoTelaControle.DataMaiorCaloriasPerdidas = pa.getData();
    	}
    	
    	ExercicioAerobico ea = new ExercicioAerobico();
    	ea = new MelhoresMediasAlunoDAO().MaiorVelocidade(textoPesquisarAlunoPorPeriodo.getText());
    	PesquisaMelhoresMediasAlunoTelaControle.MaiorVelocidade = ea.getVelocidadeMaxima();
    	PesquisaMelhoresMediasAlunoTelaControle.DataMaiorVelocidade = ea.getData();
    	
    	new MetodosPublicos().criaTela("../view/PesquisaMelhoresMediasAlunoTela.fxml");
    	
    }//AcaoBotaoPesquisarMelhoresMedias

}//PesquisaMelhoresMediasAluno
