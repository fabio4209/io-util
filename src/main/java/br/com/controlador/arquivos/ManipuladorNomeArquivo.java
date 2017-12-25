package br.com.controlador.arquivos;

public class ManipuladorNomeArquivo {

	public boolean nomeArquivoTemExtencaoTXT(String nomeArquivo){
		return nomeArquivo.endsWith(".txt");
	}
}
