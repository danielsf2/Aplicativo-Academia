package br.com.academia.controle;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.academia.modelo.Atividades;
import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TelaPesquisaAluno {

    @FXML private TextField textoPesquisarAluno;
    
    @FXML
    void AcaoBotaoPesquisarAluno(ActionEvent event) {
    	ListaAlunoNomeControler.nome = textoPesquisarAluno.getText();
    	new MetodosPublicos().criaTela("../view/AlunosNome.fxml");
    }//AcaoBotaoPesquisarAluno
    
    @FXML private DatePicker FimPeriodoPesquisa;
    @FXML private DatePicker InicioPeriodoPesquisa;
    @FXML private TextField textoPesquisarAlunoPorPeriodo;
    
    static String nomeAtividade;
    static String email;
    static Date inicio;
    static Date fim;
    @FXML
    void AcaoBotaoPesquisarAlunoPeriodo(ActionEvent event) {

    	email = textoPesquisarAlunoPorPeriodo.getText();
    	
    	Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(InicioPeriodoPesquisa.getValue().getYear(),
				InicioPeriodoPesquisa.getValue().getMonthValue()-1,InicioPeriodoPesquisa.getValue().getDayOfMonth());
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.set(FimPeriodoPesquisa.getValue().getYear(),
				FimPeriodoPesquisa.getValue().getMonthValue()-1,FimPeriodoPesquisa.getValue().getDayOfMonth());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		inicio = MetodosPublicos.tranformaStringEmDate(sdf.format(dataInicio.getTime()));
		fim = MetodosPublicos.tranformaStringEmDate(sdf.format(dataFim.getTime()));
		
		List<ExercicioAerobico> exercicio = new ExercicioAerobicoDAO().consultaExercicioEspecificoData(inicio, fim, email);
		List<PraticaEsportiva> esporte = new PraticaEsportivaDAO().pesquisaEspecificaPraticaEsportivaData(inicio, fim, email);
		
		TelaAtividadesControler.at.clear();
		
		for(ExercicioAerobico ea : exercicio) {
			Atividades atividade = new Atividades();
			atividade.setId(ea.getIdExercicio());
			atividade.setData(ea.getData());
			atividade.setNomeAtividade(ea.getTipoExercicio());
			TelaAtividadesControler.at.add(atividade);
		}
		
		for(PraticaEsportiva pa : esporte) {
			Atividades atividade = new Atividades();
			atividade.setId(pa.getId());
			atividade.setData(pa.getData());
			atividade.setNomeAtividade(pa.getTipoExercicio());
			TelaAtividadesControler.at.add(atividade);
		}
		
		new MetodosPublicos().criaTela("../view/PesquisaAtividadePorNomeTela.fxml");
		
	//new MetodosPublicos().criaTela("../view/PesquisaAtividadePorPeriodoTela.fxml");
    }//AcaoBotaoPesquisarAlunoPeriodo
    
    @FXML private DatePicker FimPeriodoPesquisaAtividade;
    @FXML private DatePicker InicioPeriodoPesquisaAtividade;
    @FXML private TextField textoPesquisarAltividadePorPeriodo;
    
    @FXML
    void AcaoBotaoPesquisarAtividadePeriodo(ActionEvent event) {
    	Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(InicioPeriodoPesquisaAtividade.getValue().getYear(),
				InicioPeriodoPesquisaAtividade.getValue().getMonthValue()-1,InicioPeriodoPesquisaAtividade.getValue().getDayOfMonth());
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.set(FimPeriodoPesquisaAtividade.getValue().getYear(),
				FimPeriodoPesquisaAtividade.getValue().getMonthValue()-1,FimPeriodoPesquisaAtividade.getValue().getDayOfMonth());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		inicio = MetodosPublicos.tranformaStringEmDate(sdf.format(dataInicio.getTime()));
		fim = MetodosPublicos.tranformaStringEmDate(sdf.format(dataFim.getTime()));

    	nomeAtividade = textoPesquisarAltividadePorPeriodo.getText();
    	
    	if(nomeAtividade.equalsIgnoreCase("caminhada") || nomeAtividade.equalsIgnoreCase("corrida")) {
    		TelaAtividadesControler.at.clear();
    		List<ExercicioAerobico> ex = new ExercicioAerobicoDAO().consultaExercicioEspecificoNome(inicio, fim, nomeAtividade);
    		for(ExercicioAerobico e : ex) {
    			Atividades atividade = new Atividades();
    			atividade.setNomeAtividade(e.getTipoExercicio());
    			atividade.setData(e.getData());
    			atividade.setId(e.getIdExercicio());
    			TelaAtividadesControler.at.add(atividade);
    		}
    		new MetodosPublicos().criaTela("../view/PesquisaAtividadePorNomeTela.fxml");
    	}
    	else {
    		TelaAtividadesControler.at.clear();
    		List<PraticaEsportiva> pa = new PraticaEsportivaDAO().pesquisaEspecificaPraticaEsportivaNome(inicio, fim, nomeAtividade);
    		for(PraticaEsportiva p : pa) {
    			Atividades atividade = new Atividades();
    			atividade.setNomeAtividade(p.getTipoExercicio());
    			atividade.setData(p.getData());
    			atividade.setId(p.getId());
    			TelaAtividadesControler.at.add(atividade);
    		}
    		new MetodosPublicos().criaTela("../view/PesquisaAtividadePorNomeTela.fxml");
    	}
    	
    }//AcaoBotaoPesquisaAtividadePorPeriodo
	
}//TelaPesquisaAluno
