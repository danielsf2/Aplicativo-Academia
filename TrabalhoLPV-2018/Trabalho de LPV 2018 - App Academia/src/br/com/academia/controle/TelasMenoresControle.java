package br.com.academia.controle;

import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelasMenoresControle {

	   @FXML
	    void AcaoBotaoErro(ActionEvent event) {
		   MetodosPublicos.erro.close();
	    }
	   
	    @FXML
	    void AcaoBotaoSucesso(ActionEvent event) {
	    	MetodosPublicos.sucesso.close();
	    }

}//TelasMenoresControle
