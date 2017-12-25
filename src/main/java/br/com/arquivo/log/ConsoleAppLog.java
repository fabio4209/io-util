package br.com.arquivo.log;

import br.com.arquivo.app.MainWindow;
import br.com.arquivo.app.MainWindowApp;

public class ConsoleAppLog {
	
	public void logar(String message){
		MainWindow mainwindows = MainWindow.getInstance();
		mainwindows.setLogMessage(message);	
	}
}
