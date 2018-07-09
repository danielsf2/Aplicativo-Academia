package br.com.academia.controle;

import java.sql.Date;
import java.sql.Time;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TelaPesquisaPorPeriodoControle {

    @FXML private Pagination alunoPaginacao;
    
    private ObservableList<ExercicioAerobico> exercicios;
    private ExercicioAerobicoDAO exercicioDao = new ExercicioAerobicoDAO();
    @FXML private TableView<ExercicioAerobico> tabelaExercicioAerobico;
	@FXML private TableColumn<ExercicioAerobico, Time> EAcolunaDuracao;
    @FXML private TableColumn<ExercicioAerobico, Double> EAcolunaVelocidadeMedia;
    @FXML private TableColumn<ExercicioAerobico, String> EAcolunaEmail;
    @FXML private TableColumn<ExercicioAerobico, Long> EAColunaIdControle;
    @FXML private TableColumn<ExercicioAerobico, Double> EAcolunaDistancia;
    @FXML private TableColumn<ExercicioAerobico, Double> EAcolunaVelocidadeMaxima;
    @FXML private TableColumn<ExercicioAerobico, Double> EAcolunaMenorElevacao;
    @FXML private TableColumn<ExercicioAerobico, String> EAcolunaTipoExercicio;
    @FXML private TableColumn<ExercicioAerobico, Double> EAcolunaMaiorElevacao;
    @FXML private TableColumn<ExercicioAerobico, Long> EAcolunaIdExercicio;
    @FXML private TableColumn<ExercicioAerobico, Time> EAcolunaRitmoMaximo;
    @FXML private TableColumn<ExercicioAerobico, Integer> EAcolunaPassos;
    @FXML private TableColumn<ExercicioAerobico, Double> EAcolunaCaloriasPerdidas;
    @FXML private TableColumn<ExercicioAerobico, Date> EAcolunaData;
    @FXML private TableColumn<ExercicioAerobico, String> EAcolunaTempo;
    @FXML private TableColumn<ExercicioAerobico, Time> EAcolunaRitmoMedio;
    
    private ObservableList<PraticaEsportiva> esportes;
    private PraticaEsportivaDAO esporteDao = new PraticaEsportivaDAO();
    @FXML private TableView<PraticaEsportiva> tabelaPraticaEsportiva;
    @FXML private TableColumn<PraticaEsportiva, Double> PAcolunaDistancia;
    @FXML private TableColumn<PraticaEsportiva, String> PAcolunaEmail;
    @FXML private TableColumn<PraticaEsportiva, String> PAcolunaTempo;
    @FXML private TableColumn<PraticaEsportiva, Time> PAcolunaDuracao;
    @FXML private TableColumn<PraticaEsportiva, Long> PAcolunaIdExercicio;
    @FXML private TableColumn<PraticaEsportiva, String> PAcolunaTipoExercicio;
    @FXML private TableColumn<PraticaEsportiva, Integer> PAcolunaPassos;
    @FXML private TableColumn<PraticaEsportiva, Date> PAcolunaData;
    @FXML private TableColumn<PraticaEsportiva, Double> PAcolunaCaloriasPerdidas;
    
    public void initialize() {
    	EAcolunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
    	EAcolunaVelocidadeMedia.setCellValueFactory(new PropertyValueFactory<>("velocidadeMedia"));
    	EAcolunaEmail.setCellValueFactory(new PropertyValueFactory<>("emailAluno"));
    	EAColunaIdControle.setCellValueFactory(new PropertyValueFactory<>("id"));
    	EAcolunaDistancia.setCellValueFactory(new PropertyValueFactory<>("distancia"));
    	EAcolunaVelocidadeMaxima.setCellValueFactory(new PropertyValueFactory<>("velocidadeMaxima"));
    	EAcolunaMenorElevacao.setCellValueFactory(new PropertyValueFactory<>("menorElevacao"));
    	EAcolunaTipoExercicio.setCellValueFactory(new PropertyValueFactory<>("tipoExercicio"));
    	EAcolunaMaiorElevacao.setCellValueFactory(new PropertyValueFactory<>("maiorelevacao"));
    	EAcolunaIdExercicio.setCellValueFactory(new PropertyValueFactory<>("idExercicio"));
    	EAcolunaRitmoMaximo.setCellValueFactory(new PropertyValueFactory<>("ritmoMaximo"));
    	EAcolunaPassos.setCellValueFactory(new PropertyValueFactory<>("ritmoMedio"));
    	EAcolunaCaloriasPerdidas.setCellValueFactory(new PropertyValueFactory<>("caloriasPerdidas"));
    	EAcolunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	EAcolunaTempo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
    	EAcolunaRitmoMedio.setCellValueFactory(new PropertyValueFactory<>("ritmoMedio"));
    	
        PAcolunaDistancia.setCellValueFactory(new PropertyValueFactory<>("distancia"));
        PAcolunaEmail.setCellValueFactory(new PropertyValueFactory<>("emailAluno"));
        PAcolunaTempo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
        PAcolunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        PAcolunaIdExercicio.setCellValueFactory(new PropertyValueFactory<>("id"));
        PAcolunaTipoExercicio.setCellValueFactory(new PropertyValueFactory<>("tipoExercicio"));
        PAcolunaPassos.setCellValueFactory(new PropertyValueFactory<>("passos"));
        PAcolunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        PAcolunaCaloriasPerdidas.setCellValueFactory(new PropertyValueFactory<>("caloriasPerdidas"));
    	
        this.exercicios = FXCollections.observableArrayList(this.exercicioDao.consultaExercicioEspecificoData
        		(TelaPesquisaAluno.inicio, TelaPesquisaAluno.fim, TelaPesquisaAluno.email));
        tabelaExercicioAerobico.setItems(exercicios);
        
        this.esportes = FXCollections.observableArrayList(this.esporteDao.pesquisaEspecificaPraticaEsportivaData
        		(TelaPesquisaAluno.inicio, TelaPesquisaAluno.fim, TelaPesquisaAluno.email));
        tabelaPraticaEsportiva.setItems(esportes);
        
        if(esportes.size()>exercicios.size()) 
        	alunoPaginacao.setPageCount(esportes.size()/4+1);
        else
        	alunoPaginacao.setPageCount(exercicios.size()/4+1);
    
    }//initalize
    
    @FXML
    void tabelaExercicioAerobicoClicar(MouseEvent mouseEvent) {
    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
    		if(mouseEvent.getClickCount()==2 && tabelaExercicioAerobico.getSelectionModel().getSelectedItem()!=null) {
    			ExercicioAerobico aerobico = tabelaExercicioAerobico.getSelectionModel().getSelectedItem();
    			TelaPesquisaPeriodoRitmo.id = aerobico.getIdExercicio();
    			new MetodosPublicos().criaTela("../view/PesquisaPorPeriodoExibeRitmo.fxml");
    		}
    	}
    }//tabelaExercicioAerobicoClicar

}//TelaPesquisaPorPeriodoControle
