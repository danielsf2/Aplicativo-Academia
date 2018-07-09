package br.com.academia.controle;

import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleGroup;

public class MenuPrincipalControle {

	  @FXML private SplitMenuButton botaoPesquisaAluno;

	    @FXML private SplitMenuButton botaoExercicioAerobico;

	    @FXML private SplitMenuButton botaoCadastrarArquivo;

	    @FXML private SplitMenuButton menuPraticasEsportivas;

	    @FXML private ToggleGroup menu;

	    @FXML private SplitMenuButton acaoAlunos;

	    @FXML private Button botaoSair;

	    @FXML private SplitMenuButton botaoUsuarios;

	       
	    @FXML
	    void AcaoBotaoCadastrarUsuario(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/UsuarioCadastrar.fxml");
	    }//AcaoBotaoCadastrarUsuario

	    @FXML
	    void AcaoBotaoPesquisarUsuario(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/UsuarioPesquisaId.fxml");
	    }//AcaoBotaoPesquisarUsuario

	    @FXML
	    void AcaoBotaoEditarUsuario(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/UsuarioEditar.fxml");
	    }//AcaoBotaoEditarUsuario

	    @FXML
	    void AcaoBotaoRemoverUsuario(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/UsuarioExcluir.fxml");
	    }//AcaoBotaoRemoverUsuario

	    @FXML
	    void AcaoBotaoListarUsuarios(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/UsuarioListarTodos.fxml");
	    }//AcaoBotaoListarUsuarios

	    @FXML
	    void AcaoBotaoRemoverEsporte(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/DeletaPraticaEsportiva.fxml");
	    }//AcaoBotaoremoverEsporte

	    @FXML
	    void AcaoBotaoEditarEsporte(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/EditarPraticaEsportiva.fxml");
	    }//AcaoBotaoEditarEsporte

	    @FXML
	    void AcaoBotaoListarTodosEsportes(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/ListarPraticaEsportiva.fxml");
	    }//AcaoBotaoListarTodosEsportes

	    @FXML
	    void AcaoBotaoRemoverExercicio(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/DeletaExercicioAerobico.fxml");
	    }//AcaoBotaoRemoverexercicio

	    @FXML
	    void AcaoBotaoEditarExercicio(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/EditarExercicioAerobico.fxml");
	    }//AcaoBotaoEditarexercicio

	    @FXML
	    void AcaoBotaoListarTodosExercicios(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/ListarExerciciosAerobicos.fxml");
	    }//AcaoBotaoListarTodosExercicios

	    @FXML
	    void AcaoBotaoEditarDadosAluno(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/TelaDadosAluno.fxml");
	    }//AcaoBotaoEditarDadosAluno

	    @FXML
	    void AcaoBotaoRemoverAluno(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/DeletaAluno.fxml");
	    }//acaoBotaoRemoverAluno

	    @FXML
	    void AcaoBotaoListarTodosAlunos(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/ListaAlunos.fxml");
	    }//AcaoBotaoListarTodosAunos

	    @FXML
	    void acaoBotaoPesquisaAlunoPorNome(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/PesquisaAlunoNome.fxml");
	    }//AcaoBotaoPesquisaAlunoNome
	    
	    @FXML
	    void AcaoBotaoPesquisaAtividadesPorPeriodo(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/PesquisaAtividadePorPeriodo.fxml");
	    }//AcaoBotaoPesquisaAtividadesPorPeriodo
	    
	    @FXML
	    void AcaoBotaoPesquisaAtividadePorPeriodoDeTempo(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/PesquisaAtividadePorNome.fxml");
	    }//AcaoBotaoPesquisaAtividadePorPeriodoDeTempo
	    
	    @FXML
	    void AcaoBotaoPesquisaMelhoresMediasDoAluno(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/PesquisaMelhoresMediasAluno.fxml");
	    }//AcaoBotaoPesquisarMelhoresMediasDoAluno

	    @FXML
	    void AcaoBotaoInserirArquivo(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/InserirArquivo.fxml");
	    }//AcaoBotaoInserirArquivo
	    
	    @FXML
	    void AcaoBotaoGraficoDeDesempenhoDoAluno(ActionEvent event) {
	    	new MetodosPublicos().criaTela("../view/GraficoDesempenhoPeriodo.fxml");
	    }//AcaoBotaoGraficoDeDesempenhoDoAluno

	    @FXML
	    void AcaoBotaoGraficoDeComparacaoDeAlunos(ActionEvent event) {

	    }//AcaoBotaoGraficoDeComparacaoDeAlunos

	    @FXML
	    void AcaoBotaoGraficoTotalDeValoresObtidos(ActionEvent event) {

	    }//AcaoBotaoGraficoTotalDeValoresObtidos

	    @FXML
	    void AcaoBotaoSair(ActionEvent event) {
	    	System.exit(0);
	    }//AcaoBotaoSair

}//MenuPrincipalControle
