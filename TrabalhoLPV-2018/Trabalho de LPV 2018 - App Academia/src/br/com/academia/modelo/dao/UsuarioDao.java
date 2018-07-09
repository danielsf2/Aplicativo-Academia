package br.com.academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.modelo.Usuario;
import br.com.academia.utils.CriaConexao;
import br.com.academia.utils.MetodosPublicos;

public class UsuarioDao {

	/**
	 * Rebe como par�metro um tipo usu�rio, trata os dados e tenta a insr��o na tabela do banco de dados.
	 * 
	 * @param Usuario usuario
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void cadastraUsuario(Usuario usuario) {
		
		String sql = "INSERT INTO usuario (usuario,senha,papel) VALUES (?,?,?)";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, usuario.getNome());
			st.setLong(2, usuario.getSenha());
			st.setString(3, usuario.getPapel());
			
			st.execute();
			
			new MetodosPublicos().telaDeSucesso();
			
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
	}//cadastraUsuario
	
	/**
	 * Recebe como parametro um Long que deve ser um id do usuario, a partir desse par�metro tenta a inser��o
	 * no banco de dados.
	 * 
	 * @param Long id
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public void removeUsuario(Long id) {
	
		String sql = "DELETE FROM usuario WHERE id=?";
		
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
	}//removeUsuario
	
	public void aualizaUsuario(Usuario usuario, Long id) {
		
		String sql = "UPDATE usuario SET id=?,usuario=?,senha=?,papel=? WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setLong(1, usuario.getId());
			st.setString(2, usuario.getNome());
			st.setLong(3, usuario.getSenha());
			st.setString(4, usuario.getPapel());
			st.setLong(5, id);
			
			st.execute();
			
			new MetodosPublicos().telaDeSucesso();
			
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		
	}//atualizaUsuario
	
	/**
	 * Recebe como par�metro um Long que tem como conte�do um id que identifica um usu�rio, pesquisa este id
	 * no Banco de Dados e retorna um Objeto Usu�rio caso tenha �xito na consulta.
	 * 
	 * @param Long id
	 * @return Usuario usuario
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Usuario pesquisaUsuario(Long id) {
		Usuario usuario = new Usuario();
		
		String sql = "SELECT*FROM usuario WHERE id=?";
		
		Connection conexao = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			
			usuario.setId(rs.getLong("id"));
			usuario.setNome(rs.getString("usuario"));
			usuario.setPapel(rs.getString("papel"));
			usuario.setSenha(rs.getLong("senha"));
			
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return usuario;
	}//pesquisaUsuario
	
	/**
	 * Pesquisa todos os usuarios cadastrados na tabela do banco de dados, insere em uma lista e retorna a lista em caso
	 * de sucesso.
	 * 
	 * @return List usuarios
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public List<Usuario> listaTodos(){
		List<Usuario> usuarios = new ArrayList<>();
		
		String sql = "SELECT*FROM usuario";
		
		Connection conexao  = new CriaConexao().getConexao("aluno", "aluno");
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("usuario"));
				usuario.setPapel(rs.getString("papel"));
				usuario.setSenha(rs.getLong("senha"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			new MetodosPublicos().telaDeErro();
		}
		return usuarios;
	}//listaTodos
	
}//UsuarioDao
