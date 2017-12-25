package  br.com.arquivo.io;

import java.io.IOException;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileUtil {

	/**
	 * Cria um arquivo vazio
	 */	
	public Path criarArquivo(String nomeCompletoArquivo) throws IOException{
		return Files.createFile(Paths.get(nomeCompletoArquivo));
	}
	
	public boolean arquivoExiste(Path arquivo){
		return Files.exists(arquivo) ? true : false;
	}
	

	
	/**
	 * @description Verifica se a string 'linha' contém a string 'filtro'
	 */
	public boolean stringContemFiltro(String linha, String filtro) {
		boolean resultado = false;
		if (linha.matches("(.*)" + filtro + "(.*)")) {
			resultado = true;
		}
		return resultado;

	}	
	
}
