package br.com.academia.utils;

import br.com.academia.InserirDao.EstruturaAluno;
import br.com.academia.InserirDao.EstruturaPraticaEsportiva;
import br.com.academia.modelo.Aluno;
import br.com.academia.modelo.PraticaEsportiva;
import br.com.academia.modelo.dao.AlunoDAO;
import br.com.academia.modelo.dao.PraticaEsportivaDAO;

public class ManipulacaoPraticaEsportiva {

	public static void cadastraPraticaEsportiva(String tipo, String dadosCompletos) {
		Aluno aluno = new EstruturaAluno().criaEstruturaAluno(dadosCompletos);
		PraticaEsportiva esporte = new EstruturaPraticaEsportiva().criaEstruturaPraticaEsportiva(tipo, dadosCompletos);
		new AlunoDAO().insereAluno(aluno);
		new PraticaEsportivaDAO().inserePraticaEsportiva(esporte);
	}
}//ManipulacaoPraticaEsportiva
