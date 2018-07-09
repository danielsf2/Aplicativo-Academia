package br.com.academia.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.utils.CriaConexao;
import br.com.academia.utils.MetodosPublicos;

public class PraticaEsportivaDAO {

	/**
	 * Recebe como parâmentro um objeto do tipo PraticaEsportiva, trata o objeto e insere no banco de dados.
	 * 
	 * @param PraticaEsportiva
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void inserePraticaEsportiva(PraticaEsportiva esporte) {
		
		String sql = "INSERT INTO pratica_esportiva(nomeatividade,data,tempo,duracao,distancia,caloriasperdidas,passos,email_aluno)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.setString(1, esporte.getTipoExercicio());
			st.setDate(2, esporte.getData());
			st.setString(3, esporte.getTempo());
			st.setTime(4, esporte.getDuracao());
			st.setDouble(5, esporte.getDistancia());
			st.setDouble(6, esporte.getCaloriasPerdidas());
			st.setInt(7, esporte.getPassos());
			st.setString(8, esporte.getEmailAluno());
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
	}//inserePraticaEsportiva
	
	/**
	 * Recebe como parametro os novos dados do objeto a ser armazenado e o Identificador do objeto que será atualizado
	 * 
	 * @param PraticaEsportiva 
	 * @param Long 
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void atualizaPraticaEsportiva(PraticaEsportiva esporte, Long id) {
		
		String sql = "UPDATE pratica_esportica SET nomeatividade=?,data=?,tempo=?,duracao=?,distancia=?,"
				+ "caloriasperdidas=?,passos=?,email_aluno=?,id=? WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, esporte.getTipoExercicio());
			st.setDate(2, esporte.getData());
			st.setString(3, esporte.getTempo());
			st.setTime(4, esporte.getDuracao());
			st.setDouble(5, esporte.getDistancia());
			st.setDouble(6, esporte.getCaloriasPerdidas());
			st.setInt(7, esporte.getPassos());
			st.setString(8, esporte.getEmailAluno());
			st.setLong(9, esporte.getId());
			st.setLong(10, id);
			
			st.execute();
			
			new MetodosPublicos().telaDeSucesso();
			
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
	}//atualizaPraticaesportiva
	
	public void removeExercicioAerobico(Long id) {
		pesquisaPraticaEsportivaId(id);
		
		String sql = "DELETE FROM pratica_esportiva WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setLong(1, id);
			st.execute();
			
			new MetodosPublicos().telaDeSucesso();
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		
	}//removeExercicioAerobico
	
	/**
	 * Recebe como parâmetro uma String contendo um formato de data que o usuário deseja consultar no banco de dados,
	 * o dado é tratado transformado em Date e pesquisado no banco de Dados, feito isso é retornado o objeto(ou Objetos),
	 * do tipo PraticaEsportiva.
	 * 
	 * @param String
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<PraticaEsportiva> pesquisaPraticaEsportivaData(String data){
		List<PraticaEsportiva>esportes = new ArrayList<>();
		
		String sql = "SELECT*FROM pratica_esportiva WHERE data=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
		    //Converte a String para date
			Date inserir = MetodosPublicos.tranformaStringEmDate(data);
			st.setDate(1, inserir);
			st.execute();
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				PraticaEsportiva esporte = new PraticaEsportiva();
				esporte.setTipoExercicio(rs.getString("nomeatividade"));
				esporte.setData(rs.getDate("data"));
				esporte.setTempo(rs.getString("tempo"));
				esporte.setDuracao(rs.getTime("duracao"));
				esporte.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				esporte.setPassos(rs.getInt("passos"));
				esporte.setDistancia(rs.getDouble("distancia"));
				esporte.setEmailAluno(rs.getString("email_aluno"));
				esporte.setId(rs.getLong("id"));
				esportes.add(esporte);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return esportes;
	}
	
	public List<PraticaEsportiva> pesquisaEspecificaPraticaEsportivaNome(Date data, Date data2, String nome){
		List<PraticaEsportiva>esportes = new ArrayList<>();
		
		String sql = "SELECT*FROM pratica_esportiva WHERE data BETWEEN ? AND ? AND nomeatividade=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setDate(1, data);
			st.setDate(2, data2);
			st.setString(3, nome);
			st.execute();
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				PraticaEsportiva esporte = new PraticaEsportiva();
				esporte.setTipoExercicio(rs.getString("nomeatividade"));
				esporte.setData(rs.getDate("data"));
				esporte.setTempo(rs.getString("tempo"));
				esporte.setDuracao(rs.getTime("duracao"));
				esporte.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				esporte.setPassos(rs.getInt("passos"));
				esporte.setDistancia(rs.getDouble("distancia"));
				esporte.setEmailAluno(rs.getString("email_aluno"));
				esporte.setId(rs.getLong("id"));
				esportes.add(esporte);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return esportes;
	}//pesquisaPraticaEsportivaNomeData
	
	public PraticaEsportiva pesquisaPraticaEsportivaId(Long id){
		PraticaEsportiva esporte = new PraticaEsportiva();
		
		String sql = "SELECT*FROM pratica_esportiva WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setLong(1, id);
			st.execute();
			
			ResultSet rs = st.executeQuery();
			rs.next();
				
			esporte.setTipoExercicio(rs.getString("nomeatividade"));
			esporte.setData(rs.getDate("data"));
			esporte.setTempo(rs.getString("tempo"));
			esporte.setDuracao(rs.getTime("duracao"));
			esporte.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
			esporte.setPassos(rs.getInt("passos"));
			esporte.setDistancia(rs.getDouble("distancia"));
			esporte.setEmailAluno(rs.getString("email_aluno"));
			esporte.setId(rs.getLong("id"));
			
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return esporte;
	}
	
	/**
	 * Recebe como parâmetro uma data de inicio e uma data de fim e uma chave identificadora do usuario que no caso seria o 
	 * email, pesquisa e retorna todos os registros do usuario encontrados nesse período.
	 * 
	 * @param Date data
	 * @param Date data2
	 * @param String email
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<PraticaEsportiva> pesquisaEspecificaPraticaEsportivaData(Date data, Date data2, String email){
		List<PraticaEsportiva>esportes = new ArrayList<>();
		
		String sql = "SELECT*FROM pratica_esportiva WHERE data BETWEEN ? AND ? AND email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setDate(1, data);
			st.setDate(2, data2);
			st.setString(3, email);
			st.execute();
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				PraticaEsportiva esporte = new PraticaEsportiva();
				esporte.setTipoExercicio(rs.getString("nomeatividade"));
				esporte.setData(rs.getDate("data"));
				esporte.setTempo(rs.getString("tempo"));
				esporte.setDuracao(rs.getTime("duracao"));
				esporte.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				esporte.setPassos(rs.getInt("passos"));
				esporte.setDistancia(rs.getDouble("distancia"));
				esporte.setEmailAluno(rs.getString("email_aluno"));
				esporte.setId(rs.getLong("id"));
				esportes.add(esporte);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return esportes;
	}
	
	/**
	 * Retorna uma lista contendo todos os objetos armazenados no Banco de Dados do tipo PraticaEsportiva.
	 * 
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<PraticaEsportiva> listaTodasPraticaEsportivas(){
		List<PraticaEsportiva>esportes = new ArrayList<>();
		
		String sql = "SELECT*FROM pratica_esportiva";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.execute();
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				PraticaEsportiva esporte = new PraticaEsportiva();
				esporte.setTipoExercicio(rs.getString("nomeatividade"));
				esporte.setData(rs.getDate("data"));
				esporte.setTempo(rs.getString("tempo"));
				esporte.setDuracao(rs.getTime("duracao"));
				esporte.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				esporte.setPassos(rs.getInt("passos"));
				esporte.setDistancia(rs.getDouble("distancia"));
				esporte.setEmailAluno(rs.getString("email_aluno"));
				esporte.setId(rs.getLong("id"));
				esportes.add(esporte);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return esportes;
	}//listaTodasPraticasEsportivas
	
	/**
	 * Pesquisa os melhores resultados obtidos pelo aluno através do email repassado.
	 * 
	 * @param String emailAluno
	 * @return Pratica esportiva
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public PraticaEsportiva pesquisaMelhoresDados(String emailAluno) {
		PraticaEsportiva melhores = new PraticaEsportiva();
		
		String sql1 = "SELECT MAX(passos) FROM pratica_esportiva WHERE email_aluno=?";
		String sql2 = "SELECT MAX(distancia) FROM pratica_esportiva WHERE email_aluno=?";
		String sql3 = "SELECT MAX(caloriasperdidas) FROM pratica_esportiva WHERE email_aluno=?";
		String sql4 = "SELECT MAX(duracao) FROM pratica_esportiva WHERE email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			PreparedStatement st2 = conexao.prepareStatement(sql2);
			PreparedStatement st3 = conexao.prepareStatement(sql3);
			PreparedStatement st4 = conexao.prepareStatement(sql4);
			st1.setString(1, emailAluno);
			st2.setString(1, emailAluno);
			st3.setString(1, emailAluno);
			st4.setString(1, emailAluno);
			st1.execute();
			st2.execute();
			st3.execute();
			st4.execute();
			ResultSet rs1 = st1.executeQuery();
			ResultSet rs2 = st2.executeQuery();
			ResultSet rs3 = st3.executeQuery();
			ResultSet rs4 = st4.executeQuery();
			rs1.next();
			rs2.next();
			rs3.next();
			rs4.next();
			melhores.setPassos(rs1.getInt("max"));
			melhores.setDistancia(rs2.getDouble("max"));
			melhores.setCaloriasPerdidas(rs3.getDouble("max"));
			melhores.setDuracao(rs4.getTime("max"));
			melhores.setEmailAluno(emailAluno);
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		System.out.println(melhores);
		return melhores;
	}
}//PraticaEsportivaDAO
