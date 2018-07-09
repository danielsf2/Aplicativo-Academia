package br.com.academia.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.utils.CriaConexao;
import br.com.academia.utils.MetodosPublicos;

public class ExercicioAerobicoDAO {

	/**
	 * Insere um exercicio Aerobico em um banco de dados para um determinado aluno do personal.
	 * 
	 * @param ExercicioAerobico
	 * @author Daniel Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void insereExercicioAerobico(ExercicioAerobico exercicio) {
		
		String sql = "INSERT INTO exercicio_aerobico"
				+"(tipoexercicio,data,duracao,distancia,caloriasperdidas,passos,velocidademedia,velocidademaxima,ritmomedio,ritmomaximo,"
				+ "menorelevacao,maiorelevacao,tempo,id_exercicio,email_aluno)"
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			//Responsavel por criar um Objeto que Executa a instrução SQL
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, exercicio.getTipoExercicio());
			statement.setDate(2, exercicio.getData());
			statement.setTime(3, exercicio.getDuracao());
			statement.setDouble(4, exercicio.getDistancia());
			statement.setDouble(5, exercicio.getCaloriasPerdidas());
			statement.setInt(6, exercicio.getPassos());
			statement.setDouble(7, exercicio.getVelocidadeMedia());
			statement.setDouble(8, exercicio.getVelocidadeMaxima());
			statement.setTime(9, exercicio.getRitmoMedio());
			statement.setTime(10, exercicio.getRitmoMaximo());
			statement.setDouble(11, exercicio.getMenorElevacao());
			statement.setDouble(12, exercicio.getMaiorelevacao());
			statement.setString(13, exercicio.getTempo());
			statement.setLong(14, exercicio.getIdExercicio());
			statement.setString(15, exercicio.getEmailAluno());
			
			//executa o comando
			statement.execute();
			statement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
	}//insereExercicioAerobico
	
	/**
	 * Recebe como parâmetro um Objeto do tipo ExercicioAerobico e um Long id, o objeto será os novos dados referentes , a tabela
	 * no banco de dados e o Long id é o Identificador do exercicio que deve ter os dados atualizados.
	 * 
	 * @param ExercicioAerobico exercicio
	 * @param Long id
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void alteraExercicioAerobico(ExercicioAerobico exercicio, Long id ) {
		
		String sql = "UPDATE exercicio_aerobico SET tipoexercicio=?,data=?,duracao=?,distancia=?,caloriasperdidas=?,passos=?,velocidademedia=?,"
				+ "velocidademaxima=?,ritmomedio=?,ritmomaximo=?, menorelevacao=?,maiorelevacao=?,tempo=?,email_aluno=?"
				+"WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, exercicio.getTipoExercicio());
			statement.setDate(2, exercicio.getData());
			statement.setTime(3, exercicio.getDuracao());
			statement.setDouble(4, exercicio.getDistancia());
			statement.setDouble(5, exercicio.getCaloriasPerdidas());
			statement.setInt(6, exercicio.getPassos());
			statement.setDouble(7, exercicio.getVelocidadeMedia());
			statement.setDouble(8, exercicio.getVelocidadeMaxima());
			statement.setTime(9, exercicio.getRitmoMedio());
			statement.setTime(10, exercicio.getRitmoMaximo());
			statement.setDouble(11, exercicio.getMenorElevacao());
			statement.setDouble(12, exercicio.getMaiorelevacao());
			statement.setString(13, exercicio.getTempo());
			statement.setString(14, exercicio.getEmailAluno());
			statement.setLong(15, exercicio.getId());
			statement.setLong(16, id);
			
			statement.execute();
			new MetodosPublicos().telaDeSucesso();
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		
	}//alteraExercicio
	
	public List<ExercicioAerobico> consultaExercicioEspecificoNome(Date data, Date data2, String nome) {
		List<ExercicioAerobico> exercicios = new ArrayList<>();
		
		String sql = "SELECT*FROM exercicio_aerobico WHERE data BETWEEN ? AND ? AND tipoexercicio=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			//Date dataInserir = MetodosPublicos.tranformaStringEmDate(data);
			statement.setDate(1, data);
			statement.setDate(2, data2);
			statement.setString(3, nome);
			statement.execute();
			
			//recupera os dados do banco de dados, atraves das conexoes SQL
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				ExercicioAerobico exercicio = new ExercicioAerobico();
				exercicio.setData(rs.getDate("data"));
				exercicio.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				exercicio.setDistancia(rs.getDouble("distancia"));
				exercicio.setDuracao(rs.getTime("duracao"));
				exercicio.setHoraFim(null);
				exercicio.setHoraInicio(null);
				exercicio.setMaiorelevacao(rs.getDouble("maiorelevacao"));
				exercicio.setMenorElevacao(rs.getDouble("menorelevacao"));
				exercicio.setPassos(rs.getInt("passos"));
				exercicio.setRitmoMaximo(rs.getTime("ritmomaximo"));
				exercicio.setRitmoMedio(rs.getTime("ritmomedio"));
				exercicio.setTempo(rs.getString("tempo"));
				exercicio.setTipoExercicio(rs.getString("tipoexercicio"));
				exercicio.setVelocidadeMaxima(rs.getDouble("velocidademaxima"));
				exercicio.setVelocidadeMedia(rs.getDouble("velocidademedia"));
				exercicio.setIdExercicio(rs.getLong("id_exercicio"));
				exercicio.setEmailAluno(rs.getString("email_aluno"));
				exercicio.setId(rs.getLong("id"));
				
				exercicios.add(exercicio);
			}
			rs.close();
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		System.out.println(exercicios.size());
		return exercicios;
	}//consultaExercicioNomeData
	
	/**
	 * Recebe como parâmetro um identificador de um campo no banco de dados, e em caso de sucesso deleta o registro do
	 * Banco de Dados.
	 * 
	 * @param Long id
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void deletaExercicioAerobico(Long id) {
		
		String sql = "DELETE FROM exercicio_aerobico WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();

			new MetodosPublicos().telaDeSucesso();
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		
	}//deletaExercicioAerobico
	
	/**
	 * Consulta um exercico Aerobico atraves da data passada pelo usuário armazena em uma variavel e retorna o valor.
	 * 
	 * @param Date data
	 * @return ExercicioAerobico
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<ExercicioAerobico> consultaExercicioData(String data) {
		List<ExercicioAerobico> exercicios = new ArrayList<>();
		
		String sql = "SELECT*FROM exercicio_aerobico WHERE data=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			
			Date dataInserir = MetodosPublicos.tranformaStringEmDate(data);
			statement.setDate(1, dataInserir);
			
			statement.execute();
			
			//recupera os dados do banco de dados, atraves das conexoes SQL
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				ExercicioAerobico exercicio = new ExercicioAerobico();
				exercicio.setData(rs.getDate("data"));
				exercicio.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				exercicio.setDistancia(rs.getDouble("distancia"));
				exercicio.setDuracao(rs.getTime("duracao"));
				exercicio.setHoraFim(rs.getTime("horafim"));
				exercicio.setHoraInicio(rs.getTime("horainicio"));
				exercicio.setMaiorelevacao(rs.getDouble("maiorelevacao"));
				exercicio.setMenorElevacao(rs.getDouble("menorelevacao"));
				exercicio.setPassos(rs.getInt("passos"));
				exercicio.setRitmoMaximo(rs.getTime("ritmomaximo"));
				exercicio.setRitmoMedio(rs.getTime("ritmomedio"));
				exercicio.setTempo(rs.getString("tempo"));
				exercicio.setTipoExercicio(rs.getString("tipoexercicio"));
				exercicio.setVelocidadeMaxima(rs.getDouble("velocidademaxima"));
				exercicio.setVelocidadeMedia(rs.getDouble("velocidademedia"));
				exercicio.setIdExercicio(rs.getLong("id_exercicio"));
				exercicio.setEmailAluno(rs.getString("email_aluno"));
				exercicio.setId(rs.getLong("id"));
				
				exercicios.add(exercicio);
			}
			rs.close();
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return exercicios;
	}//consultaExercicioData
	
	public ExercicioAerobico consultaExercicioId(Long id) {
		ExercicioAerobico exercicio = new ExercicioAerobico();
		
		String sql = "SELECT*FROM exercicio_aerobico WHERE id_exercicio=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			
			//recupera os dados do banco de dados, atraves das conexoes SQL
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			exercicio.setData(rs.getDate("data"));
			exercicio.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
			exercicio.setDistancia(rs.getDouble("distancia"));
			exercicio.setDuracao(rs.getTime("duracao"));
			exercicio.setHoraFim(null);
			exercicio.setHoraInicio(null);
			exercicio.setMaiorelevacao(rs.getDouble("maiorelevacao"));
			exercicio.setMenorElevacao(rs.getDouble("menorelevacao"));
			exercicio.setPassos(rs.getInt("passos"));
			exercicio.setRitmoMaximo(rs.getTime("ritmomaximo"));
			exercicio.setRitmoMedio(rs.getTime("ritmomedio"));
			exercicio.setTempo(rs.getString("tempo"));
			exercicio.setTipoExercicio(rs.getString("tipoexercicio"));
			exercicio.setVelocidadeMaxima(rs.getDouble("velocidademaxima"));
			exercicio.setVelocidadeMedia(rs.getDouble("velocidademedia"));
			exercicio.setIdExercicio(rs.getLong("id_exercicio"));
			exercicio.setEmailAluno(rs.getString("email_aluno"));
			exercicio.setId(rs.getLong("id"));
				
			rs.close();
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return exercicio;
	}//consultaExercicioData
	
	/**
	 * Consulta um exercico Aerobico atraves de uma data de inicio paassada pelo usuario uma data final e um id de identificação 
	 * do usuário data passada pelo usuário armazena em uma variavel e retorna o valor.
	 *
	 * @param Date, Date, String
	 * @return ExercicioAerobico
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<ExercicioAerobico> consultaExercicioEspecificoData(Date data, Date data2, String emailAluno) {
		List<ExercicioAerobico> exercicios = new ArrayList<>();
		
		String sql = "SELECT*FROM exercicio_aerobico WHERE data BETWEEN ? AND ? AND email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			//Date dataInserir = MetodosPublicos.tranformaStringEmDate(data);
			statement.setDate(1, data);
			statement.setDate(2, data2);
			statement.setString(3, emailAluno);
			statement.execute();
			
			//recupera os dados do banco de dados, atraves das conexoes SQL
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				ExercicioAerobico exercicio = new ExercicioAerobico();
				exercicio.setData(rs.getDate("data"));
				exercicio.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				exercicio.setDistancia(rs.getDouble("distancia"));
				exercicio.setDuracao(rs.getTime("duracao"));
				exercicio.setHoraFim(null);
				exercicio.setHoraInicio(null);
				exercicio.setMaiorelevacao(rs.getDouble("maiorelevacao"));
				exercicio.setMenorElevacao(rs.getDouble("menorelevacao"));
				exercicio.setPassos(rs.getInt("passos"));
				exercicio.setRitmoMaximo(rs.getTime("ritmomaximo"));
				exercicio.setRitmoMedio(rs.getTime("ritmomedio"));
				exercicio.setTempo(rs.getString("tempo"));
				exercicio.setTipoExercicio(rs.getString("tipoexercicio"));
				exercicio.setVelocidadeMaxima(rs.getDouble("velocidademaxima"));
				exercicio.setVelocidadeMedia(rs.getDouble("velocidademedia"));
				exercicio.setIdExercicio(rs.getLong("id_exercicio"));
				exercicio.setEmailAluno(rs.getString("email_aluno"));
				exercicio.setId(rs.getLong("id"));
				
				exercicios.add(exercicio);
			}
			rs.close();
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return exercicios;
	}//consultaExercicioData
	
	/**
	 * Recebe como parametro uma string, posteriormente repassa ao metodo que pesquisa a string com o email
	 * do cliente no banco de dados, e retorna os valores pedidos.
	 * 
	 * @param String email
	 * @return ExercicioAerobico melhores
	 * @author Daniel Soares Ferreira
	 */
	public ExercicioAerobico pesquisaMelhoresDados(String emailAluno) {
		ExercicioAerobico melhores = new ExercicioAerobico();
		
		String sql1 = "SELECT MAX(passos) FROM exercicio_aerobico WHERE email_aluno=?";
		String sql2 = "SELECT MAX(distancia) FROM exercicio_aerobico WHERE email_aluno=?";
		String sql3 = "SELECT MAX(caloriasperdidas) FROM exercicio_aerobico WHERE email_aluno=?";
		String sql4 = "SELECT MAX(duracao) FROM exercicio_aerobico WHERE email_aluno=?";
		String sql5 = "SELECT MAX(velocidademaxima) FROM exercicio_aerobico WHERE email_aluno=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st1 = conexao.prepareStatement(sql1);
			PreparedStatement st2 = conexao.prepareStatement(sql2);
			PreparedStatement st3 = conexao.prepareStatement(sql3);
			PreparedStatement st4 = conexao.prepareStatement(sql4);
			PreparedStatement st5 = conexao.prepareStatement(sql5);
			st1.setString(1, emailAluno);
			st2.setString(1, emailAluno);
			st3.setString(1, emailAluno);
			st4.setString(1, emailAluno);
			st5.setString(1, emailAluno);
			st1.execute();
			st2.execute();
			st3.execute();
			st4.execute();
			st5.execute();
			ResultSet rs1 = st1.executeQuery();
			ResultSet rs2 = st2.executeQuery();
			ResultSet rs3 = st3.executeQuery();
			ResultSet rs4 = st4.executeQuery();
			ResultSet rs5 = st5.executeQuery();
			rs1.next();
			rs2.next();
			rs3.next();
			rs4.next();
			rs5.next();
			melhores.setPassos(rs1.getInt("max"));
			melhores.setDistancia(rs2.getDouble("max"));
			melhores.setCaloriasPerdidas(rs3.getDouble("max"));
			melhores.setDuracao(rs4.getTime("max"));
			melhores.setVelocidadeMaxima(rs5.getDouble("max"));
			melhores.setEmailAluno(emailAluno);
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		System.out.println(melhores);
		return melhores;
	}
	
	/**
	 * Exibe todos os dados cadastrados na tabela Exercicio Aerobico
	 * 
	 * @return List
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<ExercicioAerobico> listaTodosExercicios() {
		List<ExercicioAerobico> exercicios = new ArrayList<>();
		
		String sql = "SELECT*FROM exercicio_aerobico";
		
		Connection conexao = new CriaConexao().getConexao("aluno","aluno");
		
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			
			//recupera os dados do banco de dados, atraves das conexoes SQL
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				ExercicioAerobico exercicio = new ExercicioAerobico();
				exercicio.setData(rs.getDate("data"));
				exercicio.setCaloriasPerdidas(rs.getDouble("caloriasperdidas"));
				exercicio.setDistancia(rs.getDouble("distancia"));
				exercicio.setDuracao(rs.getTime("duracao"));
				exercicio.setHoraFim(null);
				exercicio.setHoraInicio(null);
				exercicio.setMaiorelevacao(rs.getDouble("maiorelevacao"));
				exercicio.setMenorElevacao(rs.getDouble("menorelevacao"));
				exercicio.setPassos(rs.getInt("passos"));
				exercicio.setRitmoMaximo(rs.getTime("ritmomaximo"));
				exercicio.setRitmoMedio(rs.getTime("ritmomedio"));
				exercicio.setTempo(rs.getString("tempo"));
				exercicio.setTipoExercicio(rs.getString("tipoexercicio"));
				exercicio.setVelocidadeMaxima(rs.getDouble("velocidademaxima"));
				exercicio.setVelocidadeMedia(rs.getDouble("velocidademedia"));
				exercicio.setEmailAluno(rs.getString("email_aluno"));
				exercicio.setIdExercicio(rs.getLong("id_exercicio"));
				exercicio.setId(rs.getLong("id"));
				
				exercicios.add(exercicio);
			}
			rs.close();
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return exercicios;
	}//consultaExercicioData
	
}//ExercicioAerobico
