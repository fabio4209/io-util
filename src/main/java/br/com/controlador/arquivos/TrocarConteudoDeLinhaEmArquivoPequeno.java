package br.com.controlador.arquivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TrocarConteudoDeLinhaEmArquivoPequeno {

    public void trocaConteudoDeLinhaNoArquivo(Path sourcePath) throws IOException {

        List<String> lines = readPath(sourcePath);

        String line = lines.get(1); //Busca a linha numero 1

        //SUBSTITUI o conteúdo na linha
        line = line.replaceAll("(\\(\\s*)(Exception)(\\s+)", "$1java.sql.SQLException$3");

      //Seta o conteúdo na linha numero 1
        lines.set(1, line); 
        
        writePath(sourcePath, lines);
    }	

    protected List<String> readPath(Path path) throws IOException {
		return new ArrayList<>(Files.readAllLines(path, StandardCharsets.ISO_8859_1));
    }
	
    protected void writePath(Path path, List<String> lines) throws IOException {
			Files.write(path, lines, StandardCharsets.ISO_8859_1);
    }
    
}
