package br.com.academia.controle;

import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.utils.MetodosPublicos;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ExibePraticaExportivaCompleta {

    @FXML private Text caloriasPerdidasExercicio;
    @FXML private Text emailAlunoExercicio;
    @FXML private Text tipoExercicio;
    @FXML private Text identificadorExercicio;
    @FXML private Text duracaoExercicio;
    @FXML private Text dataExercicio;
    @FXML private Text tempoExercicio;
    @FXML private Text passosExercicio;
    @FXML private Text distanciaExercicio;
    
    public static PraticaEsportiva exercicio;
    
    public void initialize() {
    	
	    caloriasPerdidasExercicio.setText(exercicio.getCaloriasPerdidas().toString());
	    emailAlunoExercicio.setText(exercicio.getEmailAluno());
	    tipoExercicio.setText(exercicio.getTipoExercicio());
	    identificadorExercicio.setText(exercicio.getId().toString());;
	    duracaoExercicio.setText(MetodosPublicos.converteTimeString(exercicio.getDuracao()));;
	    dataExercicio.setText(MetodosPublicos.tranformaDateString(exercicio.getData()));;
	    tempoExercicio.setText(exercicio.getTempo());
	    passosExercicio.setText(exercicio.getPassos().toString());;
	    distanciaExercicio.setText(exercicio.getDistancia().toString()+" Km");;
	    
    }//initialize
	
}//ExibePraticaExportivaCompleta
