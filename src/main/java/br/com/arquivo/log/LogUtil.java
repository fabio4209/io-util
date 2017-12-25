package br.com.arquivo.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Patch;


public class LogUtil {
	
	private List<String> filtros;

	public List<String> getFiltro() {
		return filtros;
	}

	public void setFiltro(List<String> filtro) {
		this.filtros = filtro;
	}


	public List<String> filtrarListaLinhaArquivo(List<String> linhasDoArquivo){
		List<String> linhasFiltradasDoArquivo = new ArrayList<String>();
		for (String linhaArquivo : linhasDoArquivo) {
			if (linhaContemFiltro(linhaArquivo)){
				linhasFiltradasDoArquivo.add(linhaArquivo);
			}
		}
		return linhasFiltradasDoArquivo;
	}
	
	
	public boolean linhaContemFiltro(String linhaArquivo)	{
		for (String filtro : this.filtros) {
			if (linhaArquivo.contains(filtro)){
				return true;
			}
		}
		return false;
	}
	
	
	public void quebrarArquivoLogPorData(){
		
		//Aqui vou abrir o arquivo
		Path arquivo = Paths.get(".\\sicoobbatch.log.1.txt_BKP");

		//Aqui estou fazendo um looping nas linhas do arquivo
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(arquivo, charset)) {
			
			String linhaAtualLidaDoArquivo = null;
			String valorUltimaDataLida = "";
			
			while ((linhaAtualLidaDoArquivo = reader.readLine()) != null) {
				valorUltimaDataLida = obterValorDataNaLinhaDoArquivo(linhaAtualLidaDoArquivo);
				if (mudouValorLinhaAnteriorNoArquivo(valorUltimaDataLida, linhaAtualLidaDoArquivo)) {
					// 1 - Aqui vai fechar o arquivo atual
					// 2 - Antes de criar o nome do arquivo tem que resolver o
					//		nome do próximo arquivo a ser criado
					// 2 - Aqui vai criar um novo arquivo
				}
				linhaAtualLidaDoArquivo = null;
			}
			
		} catch (IOException ioExcepction) {
			System.err.format("IOException: %s%n", ioExcepction);
		}
		
	}
	
	//recupera o valor de data da linha atual do arquivo
	private String obterValorDataNaLinhaDoArquivo(String linha) {
		return linha.substring(0, 10);
	}	
	
	// Se não existe o valor anterior na linha atual então a função retorna true 
	private boolean mudouValorLinhaAnteriorNoArquivo(String valorAnterior, String LinhaAtual) {
		return LinhaAtual.contains(valorAnterior);
	}	
	
	
	/**
	 * @description 
	 *	Vou varrendo o arquivo e já vou escrevendo no outro arquivo.
	 * @param arquivo
	 */
	public void descobreAPrimeiraMudancaDePadrao(Path arquivo) {
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(arquivo, charset)) {

			String linhaArquivo = null;
			while ((linhaArquivo = reader.readLine()) != null) {
				System.out.println(linhaArquivo);
				linhaArquivo = null;
			}
		} catch (IOException ioExcepction) {
			System.err.format("IOException: %s%n", ioExcepction);
		}
	}	

	public void novonomearquivo(String nomeArquivo){
		
	}
	
	
}
