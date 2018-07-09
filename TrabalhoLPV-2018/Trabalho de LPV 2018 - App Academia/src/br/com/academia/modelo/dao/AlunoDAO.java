package br.com.academia.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.Aluno;
import br.com.academia.utils.CriaConexao;
import br.com.academia.utils.MetodosPublicos;

public class AlunoDAO {

	/**
	 * Recebe como parâmetro um tipo Aluno, trata o dado e adiciona ao Banco de Dados.
	 * 
	 * @param Aluno
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void insereAluno(Aluno aluno) {
		
		String sql = "INSERT INTO aluno (nomeusuario,sexo,peso,altura,datanascimento,email) VALUES(?,?,?,?,?,?)";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getSexo());
			st.setDouble(3, aluno.getPeso());
			st.setDouble(4, aluno.getAltura());
			Date data = MetodosPublicos.tranformaStringEmDate(aluno.getDataNascimento());
			st.setDate(5, data);
			st.setString(6, aluno.getEmail());
			
			st.execute();
			st.close();
			
		} catch (SQLException erroInsercao) {
		}
	}//insereAluno
	
	/**
	 * Recebe como parâmetro um Long e caso o mesmo exista no banco de dados remove a entrada.
	 * 
	 * @param Long id
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void removeAlunoId(Long id) {
		
		String sql = "DELETE FROM aluno WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			pesquisaAlunoId(id);
			st.setLong(1, id);
			
			st.execute();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
	}//removeAlunoId
	
	public void alteraAluno(Aluno aluno, Long id) {
		
		String sql = "UPDATE aluno SET nomeusuario=?,sexo=?,peso=?,altura=?,datanascimento=?,email=?,id=? WHERE id=? ";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getSexo());
			st.setDouble(3, aluno.getPeso());
			st.setDouble(4, aluno.getAltura());
			Date data = MetodosPublicos.tranformaStringEmDate(aluno.getDataNascimento());
			st.setDate(5, data);
			st.setString(6, aluno.getEmail());
			st.setLong(7, aluno.getId());
			st.setLong(8, id);
			
			st.execute();
			
			new MetodosPublicos().telaDeSucesso();
			
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		
	}//alteraAluno
	
	/**
	 * Recebe como parâmetro um Long com o Id do Aluno que é Chave primária no banco de dados. Trata o dado
	 * e retorna o tipo Aluno contendo o id repassado.
	 * 
	 * @param Long
	 * @return Aluno
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Aluno pesquisaAlunoId(Long idAluno) {
		Aluno aluno = new Aluno();
	
		String sql = "SELECT*FROM aluno WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, idAluno);
			stm.execute();
			
			ResultSet rs = stm.executeQuery();
			rs.next();
			
			aluno.setId(rs.getLong("id"));
			aluno.setNome(rs.getString("nomeusuario"));
			aluno.setPeso(rs.getDouble("peso"));
			aluno.setAltura(rs.getDouble("altura"));
			aluno.setSexo(rs.getString("sexo"));
			aluno.setDataNascimento(MetodosPublicos.tranformaDateString(rs.getDate("datanascimento")));
			aluno.setEmail(rs.getString("email"));
			
			rs.close();
			stm.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return aluno;
	}////pesquisaAlunoId
	
	/**
	 * Recebe como parâmetro uma String com o nome do Aluno que é Chave primária no banco de dados. Trata o dado
	 * e retorna o tipo Aluno contendo o nome repassado.
	 * 
	 * @param String
	 * @return Aluno
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Aluno pesquisaAlunoNome(String nomeAluno) {
		Aluno aluno = new Aluno();
	
		String sql = "SELECT*FROM aluno WHERE nomeusuario=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, nomeAluno);
			stm.execute();
			
			ResultSet rs = stm.executeQuery();
			rs.next();
			
			aluno.setId(rs.getLong("id"));
			aluno.setNome(rs.getString("nomeusuario"));
			aluno.setPeso(rs.getDouble("peso"));
			aluno.setAltura(rs.getDouble("altura"));
			aluno.setSexo(rs.getString("sexo"));
			aluno.setDataNascimento(MetodosPublicos.tranformaDateString(rs.getDate("datanascimento")));
			aluno.setEmail(rs.getString("email"));
			
			rs.close();
			stm.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return aluno;
	}////pesquisaAlunoEmail
	
	/**
	 * Retorna todos os registros do tipo Aluno armazenados no Banco de dados através de uma Lista.
	 * 
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<Aluno> pesquisaTodosAlunoNome(String nome){
		List<Aluno>alunos = new ArrayList<>();
		
		String sql = "SELECT*FROM aluno WHERE nomeusuario=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, nome);
			//stm.execute();
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nomeusuario"));
				aluno.setPeso(rs.getDouble("peso"));
				aluno.setAltura(rs.getDouble("altura"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDataNascimento(MetodosPublicos.tranformaDateString(rs.getDate("datanascimento")));
				aluno.setEmail(rs.getString("email"));
				alunos.add(aluno);
			}
			rs.close();
			stm.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return alunos;
	}//listaTodosAlunos
	
	/**
	 * Retorna todos os registros do tipo Aluno armazenados no Banco de dados através de uma Lista.
	 * 
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<Aluno> listaTodosAlunos(){
		List<Aluno>alunos = new ArrayList<>();
		
		String sql = "SELECT*FROM aluno";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			//stm.execute();
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nomeusuario"));
				aluno.setPeso(rs.getDouble("peso"));
				aluno.setAltura(rs.getDouble("altura"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDataNascimento(MetodosPublicos.tranformaDateString(rs.getDate("datanascimento")));
				aluno.setEmail(rs.getString("email"));
				alunos.add(aluno);
			}
			rs.close();
			stm.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return alunos;
	}//listaTodosAlunos
	
}//AlunoDAO
