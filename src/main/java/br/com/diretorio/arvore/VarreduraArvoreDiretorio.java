package br.com.diretorio.arvore;

//essa eh uma enum
import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import br.com.arquivo.log.ConsoleAppLog;

/*
Referência:
https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/essential/io/examples/Find.java
 
Para chamar:
VarreduraArvoreDiretorio.LocalizadorArquivo.varrerArvoreDiretorio("c:\\java","*.txt");
*/

public class VarreduraArvoreDiretorio {

	//INÍCIO DA INNER CLASS
	public static class LocalizadorArquivo extends SimpleFileVisitor<Path>{
		
		private final PathMatcher matcher;
		private int numMatches = 0;

		LocalizadorArquivo(String stringPadraoDeBusca){
			//tambem pode ser: "regex:"+ stringPadraoDeBusca
			matcher = FileSystems.getDefault().getPathMatcher("glob:"+ stringPadraoDeBusca);
		}
		
		@Override
		public FileVisitResult visitFile(Path arquivo, BasicFileAttributes attrs){
			if (nomeArquivoAtendeFiltro(arquivo)) {
				numMatches++;
				adicionarArquivoAoResultadoFinal(arquivo.toString());				
			}
			return CONTINUE;
		}
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir, 
								BasicFileAttributes attrs){
			if (nomeArquivoAtendeFiltro(dir)) {
				numMatches++;
				adicionarArquivoAoResultadoFinal(dir.toString());				
			}
			return CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFileFailed(Path arquivo, IOException exc){
			System.err.println(exc);
			return CONTINUE;
		}
		
		public static List<String> varrerArvoreDiretorio(String dirInicial, String padraoProcura) 
							throws IOException {
			Path startingDir = Paths.get(dirInicial);
			
			LocalizadorArquivo buscadorArquivo = new LocalizadorArquivo(padraoProcura);
			zerarListaArquivosResultado();
			Files.walkFileTree(startingDir, buscadorArquivo);
			List<String> listaResultado = getListaArquivosResultado();
			return listaResultado;
		}
		
		private boolean nomeArquivoAtendeFiltro(Path arquivo){
		    return arquivo.toString().contains("sws");
		  //arquivo != null && matcher.matches(arquivo) ? true : false;
		}
			
	}
	//FIM DA INNER CLASS
	
	private static List<String> arquivos = new ArrayList<String>();
	
	public static List<String> getListaArquivosResultado() {
		return arquivos;
	}	
		
	private static void adicionarArquivoAoResultadoFinal(String nomeArquivo){
		arquivos.add(nomeArquivo);
	}
	
	private static void zerarListaArquivosResultado(){
		arquivos = new ArrayList<String>();
	}

}
