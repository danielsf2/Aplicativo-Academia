package br.com.academia;
	
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class MainPhysicalApp extends Application {
	
	@FXML  private TextField fxlogin;

    @FXML private Text textoacao;

    @FXML private PasswordField fxsenha;
    
    private static Stage primary;

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../academia/view/TelaLogin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../academia/view/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Main Physical");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../academia/view/imagens/icone.png")));
			primary = primaryStage;
			primaryStage.show();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na Execução", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	 @FXML
	    void acaoBotao(ActionEvent event) {
		 	if(fxlogin.getText().equals("aluno") && fxsenha.getText().equals("aluno")) {
		 		textoacao.setText("Conectado");
		 		textoacao.setTextAlignment(TextAlignment.CENTER);
		 		textoacao.setFill(Color.DARKGREEN);
		 		try {
					AnchorPane root2 = (AnchorPane) FXMLLoader.load(getClass().getResource("../academia/view/MenuPrincipal.fxml"));
					Scene scene = new Scene(root2);
					scene.getStylesheets().add(getClass().getResource("../academia/view/css/application.css").toExternalForm());
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("Main Physical");
					stage.getIcons().add(new Image(getClass().getResourceAsStream("../academia/view/imagens/icone.png")));
					primary.close();
					stage.show();
		    	} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro na Operação", "Erro", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
		    }
		 	else{
		 		if(fxlogin.getText().equals("aluno")== false) {
		 			textoacao.setText("Login Incorreto");
		 			textoacao.setTextAlignment(TextAlignment.CENTER);
		 			textoacao.setFill(Color.DARKRED);
		 		}
		 		if(fxsenha.getText().equals("aluno")==false) {
		 			textoacao.setText("Senha Incorreta");
		 			textoacao.setTextAlignment(TextAlignment.CENTER);
		 			textoacao.setFill(Color.DARKRED);
		 		}
		 		if(fxsenha.getText().equals("aluno")==false && fxsenha.getText().equals("aluno")==false) {
		 			textoacao.setText("Login e Senha Incorretos");
		 			textoacao.setTextAlignment(TextAlignment.CENTER);
		 			textoacao.setFill(Color.DARKRED);
		 		}
		 	}
	    }//acaoBotao
	
	public static void main(String[] args) {
		launch(args);
	}
}
