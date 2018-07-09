package br.com.academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.utils.CriaConexao;
import br.com.academia.utils.MetodosPublicos;

public class MelhoresMediasAlunoDAO {

	public ExercicioAerobico MaiorVelocidade(String email) {
		ExercicioAerobico exercicio = new ExercicioAerobico();
		
		String sql = "SELECT MAX(velocidademaxima) from exercicio_aerobico WHERE email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			rs.next();
			Double maximo = 0.0;
			maximo = rs.getDouble("max");
			System.out.println(maximo);
			String sql1 = "SELECT*FROM exercicio_aerobico WHERE velocidademaxima=?";
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			st1.setDouble(1, maximo);
			st1.execute();
			ResultSet rs1 = st1.executeQuery();
			rs1.next();
			exercicio.setData(rs1.getDate("data"));
			exercicio.setCaloriasPerdidas(rs1.getDouble("caloriasperdidas"));
			exercicio.setDistancia(rs1.getDouble("distancia"));
			exercicio.setDuracao(rs1.getTime("duracao"));
			exercicio.setHoraFim(null);
			exercicio.setHoraInicio(null);
			exercicio.setMaiorelevacao(rs1.getDouble("maiorelevacao"));
			exercicio.setMenorElevacao(rs1.getDouble("menorelevacao"));
			exercicio.setPassos(rs1.getInt("passos"));
			exercicio.setRitmoMaximo(rs1.getTime("ritmomaximo"));
			exercicio.setRitmoMedio(rs1.getTime("ritmomedio"));
			exercicio.setTempo(rs1.getString("tempo"));
			exercicio.setTipoExercicio(rs1.getString("tipoexercicio"));
			exercicio.setVelocidadeMaxima(rs1.getDouble("velocidademaxima"));
			exercicio.setVelocidadeMedia(rs1.getDouble("velocidademedia"));
			exercicio.setIdExercicio(rs1.getLong("id_exercicio"));
			exercicio.setEmailAluno(rs1.getString("email_aluno"));
			exercicio.setId(rs1.getLong("id"));
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return exercicio;
	}//MaiorVelocidade
	
	public Object MaiorDistanciaPercorrida(String email) {
		
		String sql = "SELECT MAX(distancia) FROM exercicio_aerobico WHERE email_aluno=?";
		String sql1 = "SELECT MAX(distancia) FROM pratica_esportiva WHERE email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			st.setString(1, email);
			st1.setString(1, email);
			ResultSet rs = st.executeQuery();
			ResultSet rs1 = st1.executeQuery();
			rs.next();
			rs1.next();
			Double exercicio = 0.0; 
			exercicio = rs.getDouble("max");
			Double esporte = 0.0;
			esporte = rs1.getDouble("max");
			System.out.println(exercicio);
			System.out.println(esporte);
			if(exercicio >= esporte) {
				String sql3 = "SELECT*FROM exercicio_aerobico WHERE distancia=?";
				PreparedStatement st3 = conexao.prepareStatement(sql3);
				st3.setDouble(1, exercicio);
				ResultSet rs3 = st3.executeQuery();
				rs3.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setData(rs3.getDate("data"));
				ex.setCaloriasPerdidas(rs3.getDouble("caloriasperdidas"));
				ex.setDistancia(rs3.getDouble("distancia"));
				ex.setDuracao(rs3.getTime("duracao"));
				ex.setHoraFim(null);
				ex.setHoraInicio(null);
				ex.setMaiorelevacao(rs3.getDouble("maiorelevacao"));
				ex.setMenorElevacao(rs3.getDouble("menorelevacao"));
				ex.setPassos(rs3.getInt("passos"));
				ex.setRitmoMaximo(rs3.getTime("ritmomaximo"));
				ex.setRitmoMedio(rs3.getTime("ritmomedio"));
				ex.setTempo(rs3.getString("tempo"));
				ex.setTipoExercicio(rs3.getString("tipoexercicio"));
				ex.setVelocidadeMaxima(rs3.getDouble("velocidademaxima"));
				ex.setVelocidadeMedia(rs3.getDouble("velocidademedia"));
				ex.setIdExercicio(rs3.getLong("id_exercicio"));
				ex.setEmailAluno(rs3.getString("email_aluno"));
				ex.setId(rs3.getLong("id"));
				return ex;
			}
			else {
				String sql4 = "SELECT*FROM pratica_esportiva WHERE distancia=?";
				PreparedStatement st4 = conexao.prepareStatement(sql4);
				st4.setDouble(1, esporte);
				ResultSet rs4 = st4.executeQuery();
				rs4.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setTipoExercicio(rs4.getString("nomeatividade"));
				ex.setData(rs4.getDate("data"));
				ex.setTempo(rs4.getString("tempo"));
				ex.setDuracao(rs4.getTime("duracao"));
				ex.setCaloriasPerdidas(rs4.getDouble("caloriasperdidas"));
				ex.setPassos(rs4.getInt("passos"));
				ex.setDistancia(rs4.getDouble("distancia"));
				ex.setEmailAluno(rs4.getString("email_aluno"));
				ex.setId(rs4.getLong("id"));
				return ex;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return null;
	}//MaiorDistanciaPercorrida
	
	public Object MaiorNumeroCaloriasPerdidas(String email) {
		
		String sql = "SELECT MAX(caloriasperdidas) from exercicio_aerobico WHERE email_aluno=?";
		String sql1 = "SELECT MAX(caloriasperdidas) from pratica_esportiva WHERE email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			st.setString(1, email);
			st1.setString(1, email);
			ResultSet rs = st.executeQuery();
			ResultSet rs1 = st1.executeQuery();
			rs.next();
			rs1.next();
			Double exercicio = 0.0;
			exercicio = rs.getDouble("max");
			Double esporte = 0.0;
			esporte = rs1.getDouble("max");
			System.out.println(exercicio);
			System.out.println(esporte);
			if(exercicio >= esporte) {
				String sql3 = "SELECT*FROM exercicio_aerobico WHERE caloriasperdidas=?";
				PreparedStatement st3 = conexao.prepareStatement(sql3);
				st3.setDouble(1, exercicio);
				ResultSet rs3 = st3.executeQuery();
				rs3.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setData(rs3.getDate("data"));
				ex.setCaloriasPerdidas(rs3.getDouble("caloriasperdidas"));
				ex.setDistancia(rs3.getDouble("distancia"));
				ex.setDuracao(rs3.getTime("duracao"));
				ex.setHoraFim(null);
				ex.setHoraInicio(null);
				ex.setMaiorelevacao(rs3.getDouble("maiorelevacao"));
				ex.setMenorElevacao(rs3.getDouble("menorelevacao"));
				ex.setPassos(rs3.getInt("passos"));
				ex.setRitmoMaximo(rs3.getTime("ritmomaximo"));
				ex.setRitmoMedio(rs3.getTime("ritmomedio"));
				ex.setTempo(rs3.getString("tempo"));
				ex.setTipoExercicio(rs3.getString("tipoexercicio"));
				ex.setVelocidadeMaxima(rs3.getDouble("velocidademaxima"));
				ex.setVelocidadeMedia(rs3.getDouble("velocidademedia"));
				ex.setIdExercicio(rs3.getLong("id_exercicio"));
				ex.setEmailAluno(rs3.getString("email_aluno"));
				ex.setId(rs3.getLong("id"));
				return ex;
			}
			else {
				String sql4 = "SELECT*FROM pratica_esportiva WHERE caloriasperdidas=?";
				PreparedStatement st4 = conexao.prepareStatement(sql4);
				st4.setDouble(1, esporte);
				ResultSet rs4 = st4.executeQuery();
				rs4.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setTipoExercicio(rs4.getString("nomeatividade"));
				ex.setData(rs4.getDate("data"));
				ex.setTempo(rs4.getString("tempo"));
				ex.setDuracao(rs4.getTime("duracao"));
				ex.setCaloriasPerdidas(rs4.getDouble("caloriasperdidas"));
				ex.setPassos(rs4.getInt("passos"));
				ex.setDistancia(rs4.getDouble("distancia"));
				ex.setEmailAluno(rs4.getString("email_aluno"));
				ex.setId(rs4.getLong("id"));
				return ex;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return null;
	}//MaiorNumeroCaloriasPerdidas
	
	public Object MaiorNumeroPassosDados(String email) {
		
		String sql = "SELECT MAX(passos) from exercicio_aerobico WHERE email_aluno=?";
		String sql1 = "SELECT MAX(passos) from pratica_esportiva WHERE email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			st.setString(1, email);
			st1.setString(1, email);
			ResultSet rs = st.executeQuery();
			ResultSet rs1 = st1.executeQuery();
			rs.next();
			rs1.next();
			Double exercicio = 0.0; 
			exercicio = rs.getDouble("max");
			Double  esporte = 0.0;
			esporte = rs1.getDouble("max");
			System.out.println(exercicio);
			System.out.println(esporte);
			if(exercicio >= esporte) {
				String sql3 = "SELECT*FROM exercicio_aerobico WHERE passos=?";
				PreparedStatement st3 = conexao.prepareStatement(sql3);
				st3.setDouble(1, exercicio);
				ResultSet rs3 = st3.executeQuery();
				rs3.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setData(rs3.getDate("data"));
				ex.setCaloriasPerdidas(rs3.getDouble("caloriasperdidas"));
				ex.setDistancia(rs3.getDouble("distancia"));
				ex.setDuracao(rs3.getTime("duracao"));
				ex.setHoraFim(null);
				ex.setHoraInicio(null);
				ex.setMaiorelevacao(rs3.getDouble("maiorelevacao"));
				ex.setMenorElevacao(rs3.getDouble("menorelevacao"));
				ex.setPassos(rs3.getInt("passos"));
				ex.setRitmoMaximo(rs3.getTime("ritmomaximo"));
				ex.setRitmoMedio(rs3.getTime("ritmomedio"));
				ex.setTempo(rs3.getString("tempo"));
				ex.setTipoExercicio(rs3.getString("tipoexercicio"));
				ex.setVelocidadeMaxima(rs3.getDouble("velocidademaxima"));
				ex.setVelocidadeMedia(rs3.getDouble("velocidademedia"));
				ex.setIdExercicio(rs3.getLong("id_exercicio"));
				ex.setEmailAluno(rs3.getString("email_aluno"));
				ex.setId(rs3.getLong("id"));
				return ex;
			}
			else {
				String sql4 = "SELECT*FROM pratica_esportiva WHERE passos=?";
				PreparedStatement st4 = conexao.prepareStatement(sql4);
				st4.setDouble(1, esporte);
				ResultSet rs4 = st4.executeQuery();
				rs4.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setTipoExercicio(rs4.getString("nomeatividade"));
				ex.setData(rs4.getDate("data"));
				ex.setTempo(rs4.getString("tempo"));
				ex.setDuracao(rs4.getTime("duracao"));
				ex.setCaloriasPerdidas(rs4.getDouble("caloriasperdidas"));
				ex.setPassos(rs4.getInt("passos"));
				ex.setDistancia(rs4.getDouble("distancia"));
				ex.setEmailAluno(rs4.getString("email_aluno"));
				ex.setId(rs4.getLong("id"));
				return ex;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return null;
	}//MaiorNumeroPassosDados
	
	@SuppressWarnings("static-access")
	public Object MaiorDuracao(String email) {
		
		String sql = "SELECT MAX(duracao) from exercicio_aerobico WHERE email_aluno=?";
		String sql1 = "SELECT MAX(duracao) from pratica_esportiva WHERE email_aluno=?";
		
	Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			st.setString(1, email);
			st1.setString(1, email);
			ResultSet rs = st.executeQuery();
			ResultSet rs1 = st1.executeQuery();
			rs.next();
			rs1.next();
			Time exercicio = rs.getTime("max");
			Calendar c = Calendar.getInstance();
			c.setTime(exercicio);
			Integer tempo = c.HOUR*60;
			tempo += c.MINUTE;
			Time esporte = rs1.getTime("max");
			c.setTime(esporte);
			Integer tempo1 = c.HOUR*60;
			tempo1 += c.MINUTE;
			System.out.println(exercicio);
			System.out.println(esporte);
			if(tempo >= tempo1) {
				String sql3 = "SELECT*FROM exercicio_aerobico WHERE duracao=?";
				PreparedStatement st3 = conexao.prepareStatement(sql3);
				st3.setTime(1, exercicio);
				ResultSet rs3 = st3.executeQuery();
				rs3.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setData(rs3.getDate("data"));
				ex.setCaloriasPerdidas(rs3.getDouble("caloriasperdidas"));
				ex.setDistancia(rs3.getDouble("distancia"));
				ex.setDuracao(rs3.getTime("duracao"));
				ex.setHoraFim(null);
				ex.setHoraInicio(null);
				ex.setMaiorelevacao(rs3.getDouble("maiorelevacao"));
				ex.setMenorElevacao(rs3.getDouble("menorelevacao"));
				ex.setPassos(rs3.getInt("passos"));
				ex.setRitmoMaximo(rs3.getTime("ritmomaximo"));
				ex.setRitmoMedio(rs3.getTime("ritmomedio"));
				ex.setTempo(rs3.getString("tempo"));
				ex.setTipoExercicio(rs3.getString("tipoexercicio"));
				ex.setVelocidadeMaxima(rs3.getDouble("velocidademaxima"));
				ex.setVelocidadeMedia(rs3.getDouble("velocidademedia"));
				ex.setIdExercicio(rs3.getLong("id_exercicio"));
				ex.setEmailAluno(rs3.getString("email_aluno"));
				ex.setId(rs3.getLong("id"));
				return ex;
			}
			else {
				String sql4 = "SELECT*FROM pratica_esportiva WHERE duracao=?";
				PreparedStatement st4 = conexao.prepareStatement(sql4);
				st4.setTime(1, esporte);
				ResultSet rs4 = st4.executeQuery();
				rs4.next();
				ExercicioAerobico ex = new ExercicioAerobico();
				ex.setTipoExercicio(rs4.getString("nomeatividade"));
				ex.setData(rs4.getDate("data"));
				ex.setTempo(rs4.getString("tempo"));
				ex.setDuracao(rs4.getTime("duracao"));
				ex.setCaloriasPerdidas(rs4.getDouble("caloriasperdidas"));
				ex.setPassos(rs4.getInt("passos"));
				ex.setDistancia(rs4.getDouble("distancia"));
				ex.setEmailAluno(rs4.getString("email_aluno"));
				ex.setId(rs4.getLong("id"));
				return ex;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return null;
	}//MaiorDuracao
	
}//MelhoresMediasAlunoDAO
