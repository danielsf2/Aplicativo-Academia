package br.com.academia.utils;

import java.util.List;

import br.com.academia.InserirDao.EstruturaAluno;
import br.com.academia.InserirDao.EstruturaExercicioAerobico;
import br.com.academia.InserirDao.EstruturaRitmo;
import br.com.academia.modelo.Aluno;
import br.com.academia.modelo.ExercicioAerobico;
import br.com.academia.modelo.Ritmo;
import br.com.academia.modelo.dao.AlunoDAO;
import br.com.academia.modelo.dao.ExercicioAerobicoDAO;
import br.com.academia.modelo.dao.RitmoDAO;

public class ManipulacaoExercicioAerobico {

	public static void cadastraExercicioAerobico(String tipo,String dadosCompletos) {
		Aluno aluno = new EstruturaAluno().criaEstruturaAluno(dadosCompletos);
		ExercicioAerobico exercicio = new EstruturaExercicioAerobico().criaEstruturaExercicioAerobico(tipo, dadosCompletos);
		List<Ritmo> ritmo = new EstruturaRitmo().criaEstruturaRitmo(dadosCompletos);
		new AlunoDAO().insereAluno(aluno);
		new ExercicioAerobicoDAO().insereExercicioAerobico(exercicio);
		new RitmoDAO().insereRitmo(ritmo);
		new MetodosPublicos().telaDeSucesso();
		
	}//cadastraExercicioAerobico
	
}//ManipulaçãoExercicioAerobico
