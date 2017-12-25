package br.com.diretorio.arvore;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
    	try {
			VarreduraArvoreDiretorio.LocalizadorArquivo.varrerArvoreDiretorio("C:\\SisbrIDE\\apps\\JBoss\\", "*sws*.*");			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "FIM" );

	}

}
