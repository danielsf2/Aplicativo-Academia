package br.com.academia.controle;

import br.com.academia.utils.LerArquivos;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InserirArquivoControle {

    @FXML private TextField nomeArquivo;

    @FXML private Button botaoInserirArquivo;
    
    @FXML private static Text estatoInserirArquivos;

    @FXML
    void AcaoBotaoInserirArquivo(ActionEvent event) {
    	LerArquivos.abrirArquivo(nomeArquivo.getText());
    	MetodosPublicos.identificaTipoExercicio(LerArquivos.lerArquivo());
    }
    
    public static Text retornaNomeErro() {
    	return estatoInserirArquivos;
    }
	
}//InserirArquivoControle
