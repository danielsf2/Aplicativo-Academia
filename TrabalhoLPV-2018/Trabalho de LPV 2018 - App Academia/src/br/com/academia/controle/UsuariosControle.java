package br.com.academia.controle;

import br.com.academia.modelo.Usuario;
import br.com.academia.modelo.dao.UsuarioDao;
import br.com.academia.utils.MetodosPublicos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UsuariosControle {

    @FXML private TextField nomeUsuario;
    @FXML private TextField papelUsuario;
    @FXML private TextField identificadorUsuario;
    @FXML private TextField senhaUsuario;

    @FXML
    void AcaoBotaoCadastrar(ActionEvent event) {
    	Usuario usuario = new Usuario();
    	usuario.setNome(nomeUsuario.getText());
    	usuario.setPapel(papelUsuario.getText());
    	usuario.setSenha(Long.parseLong(senhaUsuario.getText()));
    	
    	new UsuarioDao().cadastraUsuario(usuario);
    	
    	nomeUsuario.setText("");
    	papelUsuario.setText("");
    	senhaUsuario.setText("");
    	
    }//AcaoBotaoCadastrar
    
    @FXML private TextField textoExcluirUsuario;
	
    @FXML
    void AcaoBotaoExluirAluno(ActionEvent event) {
    	new UsuarioDao().removeUsuario(Long.parseLong(textoExcluirUsuario.getText()));
    }
    
    @FXML private TextField novoNomeUsuario;
    @FXML private TextField identificadorUsuarioAlterar;
    @FXML private TextField novoPapelUsuario;
    @FXML private TextField novaSenhaUsuario;

    @FXML
    void AcaoBotaoAlterar(ActionEvent event) {
    	Usuario usuario = new Usuario();
    	
    	usuario.setNome(novoNomeUsuario.getText());
    	usuario.setPapel(novoPapelUsuario.getText());
    	usuario.setSenha(Long.parseLong(novaSenhaUsuario.getText()));
    	usuario.setId(Long.parseLong(identificadorUsuarioAlterar.getText()));
    	
    	new UsuarioDao().aualizaUsuario(usuario, usuario.getId());
    	
    	novoNomeUsuario.setText("");
    	novoPapelUsuario.setText("");
    	novaSenhaUsuario.setText("");
    	identificadorUsuarioAlterar.setText("");
    	
    }//AcaoBotaoAlterar
    
    @FXML private TextField textoPesquisarUsuario;
    
    @FXML
    void AcaoBotaoPesquisarUsuario(ActionEvent event) {
    	UsuariosPesquisarControle.id = Long.parseLong(textoPesquisarUsuario.getText());
    	new MetodosPublicos().criaTela("../view/UsuarioPesquisar.fxml");
    }//AcaoBotaoPesquisarUsuario
    
}//UsuariosControle
