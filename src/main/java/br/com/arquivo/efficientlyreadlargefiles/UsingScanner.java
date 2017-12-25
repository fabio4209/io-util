package br.com.arquivo.efficientlyreadlargefiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;



public class UsingScanner {

	public void readLargeFileUsingScanner(String nomeArquivo) throws Exception {
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(nomeArquivo)));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		
		} finally {
			if (sc != null) {
				sc.close();
			} 
		}
	}
}
