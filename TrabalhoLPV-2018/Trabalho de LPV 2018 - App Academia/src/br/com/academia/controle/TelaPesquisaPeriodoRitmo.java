package br.com.academia.controle;

import java.sql.Time;

import br.com.academia.modelo.Ritmo;
import br.com.academia.modelo.dao.RitmoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPesquisaPeriodoRitmo {

    
    private ObservableList<Ritmo>ritmos;
    private RitmoDAO ritmoDao = new RitmoDAO();
    @FXML private TableView<Ritmo> tabelaRitmo;
    @FXML private TableColumn<Ritmo, Double> RTkm;
    @FXML private TableColumn<Ritmo, Time> RTritmo;
    
    static Long id;
    
    public void initialize(){
    	
    	RTkm.setCellValueFactory(new PropertyValueFactory<>("km"));
        RTritmo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
    
    	this.ritmos = FXCollections.observableArrayList(this.ritmoDao.pesquisaRitmoId(id));
    	tabelaRitmo.setItems(ritmos);
    
    }//initialize
	
}//TelaPesquisaPeriodoRitmo
