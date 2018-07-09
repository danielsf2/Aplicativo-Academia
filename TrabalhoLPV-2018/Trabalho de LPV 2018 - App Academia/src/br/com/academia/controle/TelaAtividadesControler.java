package br.com.academia.controle;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.Atividades;
import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;
import br.com.academia.modelo.dao.RitmoDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TelaAtividadesControler {

	public static List<Atividades> at = new ArrayList<>();
	ObservableList<Atividades> atividades;
    @FXML private TableView<Atividades> fxTabela;
    @FXML private TableColumn<Atividades, Date> fxData;
    @FXML private TableColumn<Atividades, String> fxTipoAtividade;
    @FXML private TableColumn<Atividades, Long> fxIdentificador;
    
    public void initialize() {
    	
    	fxData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	fxIdentificador.setCellValueFactory(new PropertyValueFactory<>("id"));
    	fxTipoAtividade.setCellValueFactory(new PropertyValueFactory<>("nomeAtividade"));
    	
    	atividades = FXCollections.observableArrayList(at);
    	fxTabela.setItems(atividades);
    }

    @FXML
    void clicarAtividadeTabela(MouseEvent mouseEvent) {
    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
    		if(mouseEvent.getClickCount()==2 && fxTabela.getSelectionModel().getSelectedItem()!=null) {
    			Atividades ar = fxTabela.getSelectionModel().getSelectedItem();
    			if(ar.getNomeAtividade().equalsIgnoreCase("corrida") || ar.getNomeAtividade().equalsIgnoreCase("caminhada")) {
    				ExercicioAerobico aerobico = new ExercicioAerobico();
    				aerobico = new ExercicioAerobicoDAO().consultaExercicioId(ar.getId());
    				ExibeExercicioAerobicoCompletoControle.exercicio = aerobico;
    				ExibeExercicioAerobicoCompletoControle.ritmo = new RitmoDAO().pesquisaRitmoId(ar.getId());
    				new MetodosPublicos().criaTela("../view/ExibeExercicioAerobicoCompleto.fxml");
    			}
    			else {
    				PraticaEsportiva pa = new PraticaEsportiva();
    				pa = new PraticaEsportivaDAO().pesquisaPraticaEsportivaId(ar.getId());
    				ExibePraticaExportivaCompleta.exercicio = pa;
    				new MetodosPublicos().criaTela("../view/ExibePraticaExportivaCompleta.fxml");
    			}
    		}
    	}
    }//clicarAtividadeTabela
	
}//TelaAtividadesControler
