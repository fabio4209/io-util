package br.com.arquivo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Escrita {

	/**
	 * Não é recomendado utilizar buffer para arquivos grandes.
	 * Arquivos pequenos podem utilizar o buffer 
	 */	
	public void escreveLinhaNoFinalDoArquivo(Path arquivo, String linha) {

		Charset charset = Charset.forName("US-ASCII");
		BufferedWriter writer = null;
		
		try {
			writer = Files.newBufferedWriter(arquivo,charset,
					StandardOpenOption.APPEND);
			writer.write(linha, 0, linha.length());
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws IOException
	 */
	public void escreveNoArquivoUsandoFileWriter(Path arquivo) throws IOException {
		FileWriter fWriter = new FileWriter(arquivo.toFile());
		fWriter.write("C");
		fWriter.close();
	}
	
	/**
	 * SMALL files. If you want to write a file in one single pass 
	 * 
	 * You can use one of the write methods to write bytes, or lines, to a file
	 * (Dependendo de qual assinatura está sendo utilizada)
	 * 
	 * By default the method write creates a new file or overwrites an existing file
	 */	
	public void sobrescreverArquivoInteiro(Path arquivo, String linha){
		try {
			Files.write(arquivo, linha.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	
	/**
	 * SMALL files. If you want to write a file in one single pass 
	 * 
	 * You can use one of the write methods to write bytes, or lines, to a file
	 * (Dependendo de qual assinatura está sendo utilizada)
	 * 
	 * By default the method write creates a new file or overwrites an existing file
	 */		
    protected void sobrescreverArquivoInteiro(Path arquivo, List<String> linhas) throws IOException {
        Files.write(arquivo, linhas, StandardCharsets.UTF_8);
    }
}
