package br.com.academia.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivos {
	
	private static Scanner scanner;
	public static String dados;
	
	/**
	 * Abre um arquivo texto pelo caminho passado.
	 * @param String
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public static void abrirArquivo(String caminho) {
		String arquivo = caminho;
		
		try {
			scanner = new Scanner(new FileInputStream(arquivo));
			new MetodosPublicos().telaDeSucesso();
		}
		catch(FileNotFoundException arquivoInexistente) {
			new MetodosPublicos().telaDeErro();
		}
	}//abrirArquivo

	/**
	 * Le o Arquivo pelo caminho repassado  Através da Strind e Armazena seu conteudo em um StringBuilder e retorna a mesma.
	 * 
	 * @return String 
	 * @author Daniel Soares Ferreira
	 * @version 1.0
	 */
	public static String lerArquivo() {
		StringBuilder conteudoArquivo = new StringBuilder();
		
		while(scanner.hasNextLine()) {
			conteudoArquivo.append(scanner.nextLine()).append("\n");
		}
		return conteudoArquivo.toString();
	}//lerArquivo
	
}//LerArquivos
