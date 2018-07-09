package br.com.academia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CriaConexao {

	public Connection getConexao(String login, String senha) {
		//representa a conexao com o banco de dados a Interface Connection
		Connection connection = null;
		
		try {
			//DriverManager e o metodo que realiza a conexao com o banco de dados.
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/appevolucaodetreinamento", login, senha);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Conexao não Estabelecida", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return connection;
	}
	
	public static void main(String[] args) {
		new CriaConexao().TestarConexao();
	}

	public void TestarConexao() {

		Connection connection = new CriaConexao().getConexao("aluno","aluno");
		
		if(connection != null) {
			JOptionPane.showMessageDialog(null, "Conexão Estabelecida", "Criar Conexão", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro na Conexão", "Criar Conexão", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
}//CriaConexao
