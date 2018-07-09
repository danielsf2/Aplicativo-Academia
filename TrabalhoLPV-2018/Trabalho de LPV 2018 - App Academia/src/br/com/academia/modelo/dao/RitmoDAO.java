package br.com.academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.academia.modelo.Ritmo;
import br.com.academia.utils.CriaConexao;

public class RitmoDAO {

	/**
	 * Recebe como pâmetro um objeto do tipo Ritmo, trata o dado e o Insere no Banco de Dados.
	 * 
	 * @param Ritmo
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void insereRitmo(List<Ritmo> ritmo) {
		
		String sql = "INSERT INTO ritmo (km,tempo,id_ritmo)VALUES(?,?,?)";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			for(Ritmo rt : ritmo) {
				st.setDouble(1, rt.getKm());
				st.setTime(2, rt.getTempo());
				st.setLong(3, rt.getIdExercicio());
				st.execute();
			}
			st.close();
		}
		catch(SQLException erroNaInsercao) {
			erroNaInsercao.printStackTrace();
		}
	}//insereRitmo
	
	/**
	 * Recebe como parâmetro um id que sera pesquisado no Banco de Dados, caso encontre retornará uma Lista com o 
	 * ritmo Correspondente.
	 * 
	 * @param Long
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<Ritmo>pesquisaRitmoId(Long id){
		List<Ritmo>ritmo = new ArrayList<>();
		
		String sql = "SELECT*FROM ritmo WHERE id_ritmo=?";
		
		Connection conexao =  new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setLong(1, id);
			st.execute();
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Ritmo rit = new Ritmo();
				rit.setIdExercicio(rs.getLong("id_ritmo"));
				rit.setTempo(rs.getTime("tempo"));
				rit.setKm(rs.getDouble("km"));
				
				ritmo.add(rit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na Pesquisa - Possível Chave Inexistente", "Banco de Dados", JOptionPane.WARNING_MESSAGE);
		}
		return ritmo;
	}//pesquisaRitmoId
	
	/**
	 * Recebe como parametro os novos dados do objeto e o id do objeto que deve ser alterado. Em caso de sucesso altera
	 * os dados. 
	 *
	 * @param Ritmo ritmo
	 * @param Long id
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void atualizaRitmo(Ritmo ritmo, Long id) {
		
		String sql = "UPDATE FROM ritmo SET km=?,tempo=?,id_ritmo=?  WHERE id_ritmo=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setDouble(1, ritmo.getKm());
			st.setTime(2, ritmo.getTempo());
			st.setLong(3, ritmo.getIdExercicio());
			st.setLong(4, id);
			
			st.execute();
			JOptionPane.showMessageDialog(null, "Dados Atualizados");
			st.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na Atualização dos Dados", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}//atualizaRitmo
	
	/**
	 * Deleta um objeto do banco de dados Atravé do Identificador passado como parâmetro.
	 * @param Long id
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void deletaRitmo(Long id) {
		
		String sql = "DELETE FROM ritmo WHERE id_ritmo=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			JOptionPane.showMessageDialog(null, "Exclusão Realizada com Sucesso");
			st.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na Exclusão dos Dados", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}//deletaRitmo
	
}//RitmoDAO