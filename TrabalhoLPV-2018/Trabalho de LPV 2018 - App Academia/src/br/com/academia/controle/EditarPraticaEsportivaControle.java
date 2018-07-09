package br.com.academia.controle;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditarPraticaEsportivaControle {

    @FXML private TextField textoExcluirPraticaEsportiva;
   
    @FXML private TextField alterarCaloriasPerdidas;
    @FXML private TextField alterarPassos;
    @FXML private TextField alterarEmail;
    @FXML private TextField alterarDistancia;
    @FXML private TextField alterarNomeExercicio;
    @FXML private TextField alterarTempo;
    @FXML private TextField alterarIdentificadorExercicio;
    @FXML private TextField alterarData;
    @FXML private TextField alterarDuracao;

    @FXML
    void AcaoBotaoExcluirEsporte(ActionEvent event) {
    	new PraticaEsportivaDAO().removeExercicioAerobico(Long.parseLong(textoExcluirPraticaEsportiva.getText()));
    	
    }//AcaoBotaoExcluirEsporte
    
    @FXML
    void AcaoBotaoAlterar(ActionEvent event) {
    	ExercicioAerobico exercicio = new ExercicioAerobico();
    	
        exercicio.setCaloriasPerdidas(Double.parseDouble(alterarCaloriasPerdidas.getText()));
        exercicio.setPassos(Integer.parseInt(alterarPassos.getText()));
        exercicio.setEmailAluno(alterarEmail.getText());
        exercicio.setDistancia(Double.parseDouble(alterarDistancia.getText()));
        exercicio.setTipoExercicio(alterarNomeExercicio.getText());
        exercicio.setTempo(alterarTempo.getText());
        exercicio.setId(Long.parseLong(alterarIdentificadorExercicio.getText()));
        exercicio.setData(MetodosPublicos.tranformaStringEmDate(alterarData.getText()));
        exercicio.setDuracao(MetodosPublicos.converteStringEmTime(alterarDuracao.getText()));
        
        new ExercicioAerobicoDAO().alteraExercicioAerobico(exercicio, exercicio.getId());
        
        alterarCaloriasPerdidas.getText();
        alterarPassos.getText();
        alterarEmail.getText();
        alterarDistancia.getText();
        alterarNomeExercicio.getText();
        alterarTempo.getText();
        alterarIdentificadorExercicio.getText();
        alterarData.getText();
        alterarDuracao.getText();
    }//AcaoBotaoAlterar

}//EditarPraticaEsportivaControle
