package br.com.academia.controle;

import br.com.academia.modelo.Usuario;
import br.com.academia.modelo.dao.UsuarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuarioListarTodosControle {

    @FXML private Pagination usuarioPaginacao;
    
    private ObservableList<Usuario> usuarios;
    private UsuarioDao usuarioDao = new UsuarioDao();

    @FXML private TableView<Usuario> tabelaUsuarios;
    @FXML private TableColumn<Usuario, String> colunaPapel;
    @FXML private TableColumn<Usuario, String> colunaNomeUsuario;
    @FXML private TableColumn<Usuario, Long> colunaSenha;
    @FXML private TableColumn<Usuario, Long> colunaIdentificador;
    
    public void initialize() {

        colunaPapel.setCellValueFactory(new PropertyValueFactory<>("papel"));
        colunaNomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        colunaIdentificador.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        this.usuarios = FXCollections.observableArrayList(this.usuarioDao.listaTodos());
        tabelaUsuarios.setItems(usuarios);
        usuarioPaginacao.setPageCount(usuarios.size()/4+1);
    }//initialize
	
}//UsuarioListarTodosControle
