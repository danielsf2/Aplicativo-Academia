package br.com.academia.controle;

import java.sql.Date;
import java.sql.Time;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaExerciciosAerobicosControle {

	 @FXML private Pagination alunoPaginacao;
	 
	 private ObservableList<ExercicioAerobico>exercicios;
	 private ExercicioAerobicoDAO exercicioDao = new ExercicioAerobicoDAO();
	 @FXML private TableView<ExercicioAerobico> tabelaExercicioAerobico;
	 @FXML private TableColumn<ExercicioAerobico, Time> colunaMaiorElevacao;
     @FXML private TableColumn<ExercicioAerobico, Time> colunaRitmoMedio;
     @FXML private TableColumn<ExercicioAerobico, Long> colunaIdExercicio;
     @FXML private TableColumn<ExercicioAerobico, Date> colunaData;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaDistancia;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaTempo;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaTipoExercicio;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaMenorElevacao;
     @FXML private TableColumn<ExercicioAerobico, Integer> colunaPassos;
     @FXML private TableColumn<ExercicioAerobico, String> colunaEmail;
     @FXML private TableColumn<ExercicioAerobico, Time> colunaDuracao;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaCaloriasPerdidas;
     @FXML private TableColumn<ExercicioAerobico, Long> ColunaIdControle;
     @FXML private TableColumn<ExercicioAerobico, Date> colunaRitmoMaximo;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaVelocidadeMaxima;
     @FXML private TableColumn<ExercicioAerobico, Double> colunaVelocidadeMedia;

     public void initialize() {
    	
    	 colunaMaiorElevacao.setCellValueFactory(new PropertyValueFactory<>("maiorelevacao"));
         colunaRitmoMedio.setCellValueFactory(new PropertyValueFactory<>("ritmoMedio"));
         colunaIdExercicio.setCellValueFactory(new PropertyValueFactory<>("idExercicio"));
         colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
         colunaDistancia.setCellValueFactory(new PropertyValueFactory<>("distancia"));
         colunaTempo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
         colunaTipoExercicio.setCellValueFactory(new PropertyValueFactory<>("tipoExercicio"));
         colunaMenorElevacao.setCellValueFactory(new PropertyValueFactory<>("menorElevacao"));
         colunaPassos.setCellValueFactory(new PropertyValueFactory<>("passos"));
         colunaEmail.setCellValueFactory(new PropertyValueFactory<>("emailAluno"));
         colunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
         colunaCaloriasPerdidas.setCellValueFactory(new PropertyValueFactory<>("caloriasPerdidas"));
         ColunaIdControle.setCellValueFactory(new PropertyValueFactory<>("id"));
         colunaRitmoMaximo.setCellValueFactory(new PropertyValueFactory<>("ritmoMaximo"));
         colunaVelocidadeMaxima.setCellValueFactory(new PropertyValueFactory<>("velocidadeMaxima"));
         colunaVelocidadeMedia.setCellValueFactory(new PropertyValueFactory<>("velocidadeMedia"));
         
         this.exercicios = FXCollections.observableArrayList(this.exercicioDao.listaTodosExercicios());
         tabelaExercicioAerobico.setItems(exercicios);
         alunoPaginacao.setPageCount(exercicios.size()/4+1);
     }
     
}//ListaExerciciosAerobicosControle
