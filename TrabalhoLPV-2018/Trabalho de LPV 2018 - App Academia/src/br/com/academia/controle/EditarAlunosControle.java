package br.com.academia.controle;

import br.com.academia.modelo.Aluno;
import br.com.academia.modelo.dao.AlunoDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditarAlunosControle {
	
    @FXML private TextField alterarDataNascimento;
    @FXML private TextField alterarNome;
    @FXML private TextField alterarAltura;
    @FXML private TextField alterarSexo;
    @FXML private TextField alterarIdentificador;
    @FXML private TextField alterarEmail;
    @FXML private TextField alterarPeso;
    
    @FXML private TextField textoExcluirAluno;

	  @FXML
	    void AcaoBotaoAlterar(ActionEvent event) {
	    	try {
		    	Aluno aluno = new Aluno();
		    	aluno.setNome(alterarNome.getText());
		    	aluno.setSexo(alterarSexo.getText());
		    	aluno.setAltura(Double.parseDouble(alterarAltura.getText()));
		    	aluno.setPeso(Double.parseDouble(alterarPeso.getText()));
		    	aluno.setDataNascimento(alterarDataNascimento.getText());
		    	aluno.setEmail(alterarEmail.getText());
		    	aluno.setId(Long.parseLong(alterarIdentificador.getText()));
		    	new AlunoDAO().alteraAluno(aluno, aluno.getId());
		    	new MetodosPublicos().telaDeSucesso();
		    	alterarDataNascimento.setText("");
		        alterarNome.setText("");
		        alterarAltura.setText("");
		        alterarSexo.setText("");
		        alterarIdentificador.setText("");
		        alterarEmail.setText("");
		        alterarPeso.setText("");
		    	
	    	}
	    	catch(Exception e) {
	    		new MetodosPublicos().telaDeErro();
	    	}
	    }//AcaoBotaoAlterar
	  
	    @FXML
	    void AcaoBotaoDeletarAluno(ActionEvent event) {
	    	try {
	    		new AlunoDAO().removeAlunoId(Long.parseLong(textoExcluirAluno.getText()));
	    		new MetodosPublicos().telaDeSucesso();
	    	}
	    	catch(Exception e) {
	    		new MetodosPublicos().telaDeErro();
	    	}
	    }
	  

}//EditarAlunosControle
