package br.com.academia.InserirDao;

import br.com.academia.modelo.Aluno;
import br.com.academia.utils.MetodosPublicos;

public class EstruturaAluno {
	
	private static String emailUsuario;

	/**
	 * Recebe o nome do exercicio ja recuperado no método anterior e os dados recuperados do arquivo texto,
	 * é responsável por gerar e retornar um Objeto do tipo ExercicioAerobico.
	 * @param String
	 * @param String
	 * @return Aluno
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Aluno criaEstruturaAluno(String dadosCompletos) {
		Aluno aluno = new Aluno();
		aluno.setNome(MetodosPublicos.recuperaNome(dadosCompletos));
		aluno.setSexo(recuperaSexo(dadosCompletos));
		aluno.setAltura(recuperaAltura(dadosCompletos));
		aluno.setPeso(recuperaPeso(dadosCompletos));
		aluno.setDataNascimento(recuperaDataNascimento(dadosCompletos));
		aluno.setEmail(recuperaEmail(dadosCompletos));
		emailUsuario = aluno.getEmail();
		
		return aluno;
	}
	/**
	 * Recebe como parametro a String com os dados recuperados do Arquivo Texto, recupera o sexo do
	 * usuário do arquivo e o retorna.
	 * @param String
	 * @return String
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public String recuperaSexo(String dadosCompletos) {
		String sexo = new String( MetodosPublicos.recuperaString(dadosCompletos, "Sexo:", "Altura:"));
		return sexo;
	}//recuperaSexo
		
	/**
	 * Recece como parâmetro uma String contendo os dados recuperados do Arquivo texto, refina os dados e
	 * recupera a altura do aluno, tranforma o dado em double e o retorna.
	 * 
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaAltura(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Altura:", "m");
		dados = dados.replace(',' , '.');
		Double altura = Double.parseDouble(dados);
		return altura;
	}//recuperaAltura
	
	/**
	 * Recebe como parâmetro um String contendo os dados recuperados do arquivo texto, refina os dados e recupera
	 * o peso, tranforma o dado em Double e o retorna.
	 * 
	 * @param String
	 * @return Double
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public Double recuperaPeso(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "Peso:", "Kg");
		dados = dados.replace(',' ,  '.');
		Double peso = Double.parseDouble(dados);
		return peso;
	}//recuperaPeso
	
	/**
	 * Reecebe como parâmentro uma String contendo os dados recuperados do Arquivo texto, refina os dados e obtem 
	 * a data de nascimento, tranforma a data em um formato desejado para pesquisa e arquivemento em um banco de
	 * dados e retorna o valor.
	 * 
	 * @param String
	 * @return Date
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public String recuperaDataNascimento(String dadosCompletos) {
		String dados = MetodosPublicos.recuperaString(dadosCompletos, "nascimento:", "\n");
		return dados;
	}//recuperaDataNascimento
	
	/**
	 * Recebe como parâmetro uma String contendo os dados recuperados do Aqruivo texto, refina os dados, recupera
	 * o Email e o retorna.
	 * 
	 * @param String
	 * @return String
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public String recuperaEmail(String dadosCompletos) {
		String email = MetodosPublicos.recuperaString(dadosCompletos, "E-mail:", "\n");
		return email;
	}//recuperaEmail
	
	public static String extraiIEmailAluno() {
		return emailUsuario;
	}
	
}//EstruturaAluno
