package br.com.academia.controle;

import java.sql.Date;

import br.com.academia.modelo.Aluno;
import br.com.academia.modelo.dao.AlunoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaAlunoNomeControler {

	 @FXML private Pagination alunoPaginacao;
		
		private ObservableList<Aluno> aluno;
		private AlunoDAO alunoDao = new AlunoDAO();
		@FXML private TableView<Aluno> tabelaAlunos;
	   	@FXML private TableColumn<Aluno, String> colunaEmail;
	    @FXML private TableColumn<Aluno, Double> colunaAltura;
	    @FXML private TableColumn<Aluno, Integer> colunaId;
	    @FXML private TableColumn<Aluno, Double> colunaPeso;
	    @FXML private TableColumn<Aluno, Date> colunaDataNacimento;
	    @FXML private TableColumn<Aluno, String> colunaNome;
	    @FXML private TableColumn<Aluno, String> colunaSexo;
	    
	    static String nome;
	    
	    public void initialize() {
	    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	    	colunaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
	    	colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
	    	colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
	    	colunaDataNacimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
	    	colunaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
	    	colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
	    	
	    	this.aluno = FXCollections.observableArrayList(this.alunoDao.pesquisaTodosAlunoNome(nome));
	    	tabelaAlunos.setItems(aluno);
	    	alunoPaginacao.setPageCount(aluno.size()/4+1);
	    }
}//ListaAlunoNomeControler
