package br.com.academia.controle;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditarExercicioAerobicoControle {

    @FXML private TextField textoExcluirExercicioAerobico;
    
    @FXML private TextField alterarMenorElevacao;
    @FXML private TextField alterarMaiorElevacao;
    @FXML private TextField alterarCaloriasPerdidas;
    @FXML private TextField alterarVelocidadeMedia;
    @FXML private TextField alterarPassos;
    @FXML private TextField alterarEmail;
    @FXML private TextField alterarRitmoMedio;
    @FXML private TextField alterarVelocidadeMaxima;
    @FXML private TextField alterarDistancia;
    @FXML private TextField alterarRitmoMaximo;
    @FXML private TextField alterarNomeExercicio;
    @FXML private TextField alterarTempo;
    @FXML private TextField alterarIdentificadorExercicio;
    @FXML private TextField alterarData;
    @FXML private TextField alterarDuracao;

    @FXML
    void AcaoBotaoExcluirExercicio(ActionEvent event) {
    	new ExercicioAerobicoDAO().deletaExercicioAerobico(Long.parseLong(textoExcluirExercicioAerobico.getText()));
    }//acaoBotaoExluirExercicio
    
    @FXML
    void AcaoBotaoAlterar(ActionEvent event) {
    	ExercicioAerobico exercicio = new ExercicioAerobico();
    	
    	exercicio.setMenorElevacao(Double.parseDouble(alterarMenorElevacao.getText()));
        exercicio.setMaiorelevacao(Double.parseDouble(alterarMaiorElevacao.getText()));
        exercicio.setCaloriasPerdidas(Double.parseDouble(alterarCaloriasPerdidas.getText()));
        exercicio.setVelocidadeMedia(Double.parseDouble(alterarVelocidadeMedia.getText()));
        exercicio.setPassos(Integer.parseInt(alterarPassos.getText()));
        exercicio.setEmailAluno(alterarEmail.getText());
        exercicio.setRitmoMedio(MetodosPublicos.converteStringEmTime(alterarRitmoMedio.getText()));
        exercicio.setVelocidadeMaxima(Double.parseDouble(alterarVelocidadeMaxima.getText()));
        exercicio.setDistancia(Double.parseDouble(alterarDistancia.getText()));
        exercicio.setRitmoMaximo(MetodosPublicos.converteStringEmTime(alterarRitmoMaximo.getText()));
        exercicio.setTipoExercicio(alterarNomeExercicio.getText());
        exercicio.setTempo(alterarTempo.getText());
        exercicio.setId(Long.parseLong(alterarIdentificadorExercicio.getText()));
        exercicio.setData(MetodosPublicos.tranformaStringEmDate(alterarData.getText()));
        exercicio.setDuracao(MetodosPublicos.converteStringEmTime(alterarDuracao.getText()));
        
        new ExercicioAerobicoDAO().alteraExercicioAerobico(exercicio, exercicio.getId());
    }//AcaoBotaoAlterar
    
}//EditarExercicioAerobicoControle
