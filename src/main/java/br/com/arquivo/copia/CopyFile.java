package br.com.arquivo.copia;

import java.awt.image.ReplicateScaleFilter;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {

	public static void main(String[] args) {

	}

	/**
	 * Nesse método a origem e o destino tem que ser caminho para 'arquivos'
	 */
	public void copiaArquivoOld() throws IOException {
		Path arquivoDestino = Paths.get(
				"C:\\java\\workspace_java\\arquivos-controlador\\testeCopyfile\\" + 
				"destino\\TesteDeCopiaDeArquivo.txt");
		Path arquivoOrigem = Paths.get(
				"C:\\java\\workspace_java\\arquivos-controlador\\testeCopyfile\\" + 
				"origem\\TesteDeCopiaDeArquivo.txt");
		Files.copy(arquivoOrigem, arquivoDestino, StandardCopyOption.REPLACE_EXISTING);
	}

	public void copiaArquivo() throws IOException {
		Path arquivoDestino = Paths.get(
				"..\\testeCopyfile\\" + 
				"destino\\TesteDeCopiaDeArquivo.txt");
		Path arquivoOrigem = Paths.get(
				"C:\\java\\workspace_java\\arquivos-controlador\\testeCopyfile\\" + 
				"origem\\TesteDeCopiaDeArquivo.txt");
		Files.copy(arquivoOrigem, arquivoDestino, StandardCopyOption.REPLACE_EXISTING);
	}

	
}
