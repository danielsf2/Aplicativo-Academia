package br.com.academia.controle;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.Ritmo;
import br.com.academia.utils.MetodosPublicos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ExibeExercicioAerobicoCompletoControle {

	    @FXML private Text menorElevacaoExercicio;
	    @FXML private Text caloriasPerdidasExercicio;
	    @FXML private Text velocidadeMediaExercicio;
	    @FXML private Text velocidadeMaximaExercicio;
	    @FXML private Text emailAlunoExercicio;
	    @FXML private Text tipoExercicio;
	    @FXML private Text identificadorExercicio;
	    @FXML private Text duracaoExercicio;
	    @FXML private Text dataExercicio;
	    @FXML private Text ritmoMedioExercicio;
	    @FXML private Text idControleExercicio;
	    @FXML private Text tempoExercicio;
	    @FXML private Text maiorElevacaoExercicio;
	    @FXML private Text passosExercicio;
	    @FXML private Text ritmoMaximoExercicio;
	    @FXML private Text distanciaExercicio;
	    
	    @FXML private TableView<Ritmo> tabelaRitmo;
	    @FXML private TableColumn<Ritmo, Double> exercicioKm;
	    @FXML private TableColumn<Ritmo, Time> exercicioRitmo;
	    
	    private ObservableList<Ritmo>ritmos;
	    public static List<Ritmo>ritmo = new ArrayList<>();
	    
	    public static ExercicioAerobico exercicio;
	    
	    public void initialize() {
	    	
	    	menorElevacaoExercicio.setText(exercicio.getMenorElevacao().toString()+" Metros");
		    caloriasPerdidasExercicio.setText(exercicio.getCaloriasPerdidas().toString());
		    velocidadeMediaExercicio.setText(exercicio.getVelocidadeMedia().toString()+" Km");
		    velocidadeMaximaExercicio.setText(exercicio.getVelocidadeMedia().toString()+" Km");
		    emailAlunoExercicio.setText(exercicio.getEmailAluno());
		    tipoExercicio.setText(exercicio.getTipoExercicio());
		    identificadorExercicio.setText(exercicio.getIdExercicio().toString());
		    duracaoExercicio.setText(MetodosPublicos.converteTimeString(exercicio.getDuracao()));
		    dataExercicio.setText(MetodosPublicos.tranformaDateString(exercicio.getData()));
		    ritmoMedioExercicio.setText(MetodosPublicos.converteTimeString(exercicio.getRitmoMedio()));
		    idControleExercicio.setText(exercicio.getId().toString());
		    tempoExercicio.setText(exercicio.getTempo());
		    maiorElevacaoExercicio.setText(exercicio.getMaiorelevacao().toString()+" Metros");
		    passosExercicio.setText(exercicio.getPassos().toString());
		    ritmoMaximoExercicio.setText(MetodosPublicos.converteTimeString(exercicio.getRitmoMaximo()));
		    distanciaExercicio.setText(exercicio.getDistancia().toString()+" Km");
		    
		    exercicioKm.setCellValueFactory(new PropertyValueFactory<>("km"));
		    exercicioRitmo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
		    
		    ritmos = FXCollections.observableArrayList(ritmo);
		    tabelaRitmo.setItems(ritmos);
		    
	    }//initialize
	
}//ExibeExercicioAerobicoCompletoControle
