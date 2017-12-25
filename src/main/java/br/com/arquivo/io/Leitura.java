package br.com.arquivo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Leitura {

	private Path arquivo;
	
	public Leitura(){}
	
	public Leitura(Path arquivo){
		this.arquivo = arquivo;
	}
	
	/**
	 * Não é recomendado utilizar buffer para arquivos grandes.
	 * Arquivos pequenos podem utilizar o buffer 
	 */	
	public void leArquivoPorLinha(Path arquivo){
		
		Charset charset = StandardCharsets.UTF_8;
		try (BufferedReader reader = Files.newBufferedReader(arquivo,charset)) {
			String line = null;
			while ((line = reader.readLine()) != null){
				System.out.println(line);
				line = null;
			}
			
		} catch (IOException ioExcepction){
			System.err.format("IOException: %s%n", ioExcepction);
		}
				
	}
	
	/**
	 * QUAL A DIFERENÇA ENTRE Files.readAllLines e
	 * BufferedReader reader = Files.newBufferedReader ???????
	 * 
	 * The most robust way is to use IOUTils from apache commons
	 * 
	 */
	public List<String> deArquivoParaLista() throws IOException {
		return new ArrayList<>(Files.readAllLines(this.arquivo, StandardCharsets.UTF_8));
	}
	
	/**
	 * QUAL A DIFERENÇA ENTRE Files.readAllLines e
	 * BufferedReader reader = Files.newBufferedReader ???????
	 * 
	 * The most robust way is to use IOUTils from apache commons
	 * https://stackoverflow.com/questions/17084657/most-robust-way-of-reading-a-file-or-stream-using-java-to-prevent-dos-attacks
	 */	
	public List<String> converteArquivoParaLista(Path arquivo) throws IOException {
		Charset charset = StandardCharsets.UTF_8;
		List<String> listaLinhasDoArquivo = new ArrayList<String>();
		
		try (BufferedReader reader = Files.newBufferedReader(arquivo,charset)) {

			String linhaArquivo = null;

			while ((linhaArquivo = reader.readLine()) != null){
				listaLinhasDoArquivo.add(linhaArquivo);
				linhaArquivo = null;
			}

		}
		return listaLinhasDoArquivo;
	}	
	
	
}
