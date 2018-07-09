package br.com.academia.controle;

import java.sql.Date;
import java.sql.Time;

import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarPraticaEsportivaControle {

	@FXML private Pagination alunoPaginacao;
	 
	 private ObservableList<PraticaEsportiva>exercicios;
	 private PraticaEsportivaDAO exercicioDao = new PraticaEsportivaDAO();
	 @FXML private TableView<PraticaEsportiva> tabelaExercicioAerobico;
     @FXML private TableColumn<PraticaEsportiva, Long> colunaIdExercicio;
     @FXML private TableColumn<PraticaEsportiva, Date> colunaData;
     @FXML private TableColumn<PraticaEsportiva, Double> colunaDistancia;
     @FXML private TableColumn<PraticaEsportiva, Double> colunaTempo;
     @FXML private TableColumn<PraticaEsportiva, Double> colunaTipoExercicio;
     @FXML private TableColumn<PraticaEsportiva, Integer> colunaPassos;
     @FXML private TableColumn<PraticaEsportiva, String> colunaEmail;
     @FXML private TableColumn<PraticaEsportiva, Time> colunaDuracao;
     @FXML private TableColumn<PraticaEsportiva, Double> colunaCaloriasPerdidas;

    public void initialize() {
   	
        colunaIdExercicio.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaDistancia.setCellValueFactory(new PropertyValueFactory<>("distancia"));
        colunaTempo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
        colunaTipoExercicio.setCellValueFactory(new PropertyValueFactory<>("tipoExercicio"));
        colunaPassos.setCellValueFactory(new PropertyValueFactory<>("passos"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("emailAluno"));
        colunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        colunaCaloriasPerdidas.setCellValueFactory(new PropertyValueFactory<>("caloriasPerdidas"));
        
        this.exercicios = FXCollections.observableArrayList(this.exercicioDao.listaTodasPraticaEsportivas());
        tabelaExercicioAerobico.setItems(exercicios);
        alunoPaginacao.setPageCount(exercicios.size()/4+1);
    }
	
}//ListarPraticaEsportivaControle
