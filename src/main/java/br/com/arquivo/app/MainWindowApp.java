package br.com.arquivo.app;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

import br.com.arquivo.efficientlyreadlargefiles.UsingScanner;


import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainWindowApp extends JFrame{
	public MainWindowApp() {
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = MainWindow.getInstance();
					window.tornarVisivel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}




}
