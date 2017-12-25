package br.com.arquivo.app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.arquivo.efficientlyreadlargefiles.UsingScanner;
import br.com.diretorio.arvore.VarreduraArvoreDiretorio;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame{
	
	private static MainWindow INSTANCE;
	
	public JFrame frame;
	public JTextField tfCaminhoArquivo;	
	public JTextArea txtConsole;
	
	private MainWindow() {
		initialize();
	}
	
	public void tornarVisivel(){
		this.frame.setVisible(true);
	}
	
	public static MainWindow getInstance() {
		if (INSTANCE == null){
			INSTANCE = new MainWindow();
		}
		return INSTANCE;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1075, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIncio = new JButton("LerArquivoGrande");
		btnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("botao clicado");
				UsingScanner readFileComScanner = new UsingScanner();
				try {
				String nomeCompletoArquivo = tfCaminhoArquivo.getText().replace("\\", "\\\\");
				readFileComScanner.readLargeFileUsingScanner(nomeCompletoArquivo);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnIncio.setBounds(157, 49, 137, 27);
		frame.getContentPane().add(btnIncio);
		
		
		JButton btnEncontrarPasta = new JButton("");
		btnEncontrarPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                if (chooser.showOpenDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION) {
                	tfCaminhoArquivo.setText(chooser.getSelectedFile().getAbsolutePath());
                }				
			}
		});
		btnEncontrarPasta.setIcon(new ImageIcon(MainWindowApp.class.getResource("/javax/swing/plaf/metal/icons/ocean/newFolder.gif")));
		btnEncontrarPasta.setBounds(10, 11, 53, 27);
		frame.getContentPane().add(btnEncontrarPasta);
		
		
		tfCaminhoArquivo = new JTextField();
		tfCaminhoArquivo.setFont(new Font("Consolas", Font.PLAIN, 14));
		tfCaminhoArquivo.setText("C:\\Users\\fabior\\Documents\\workspace-pessoal\\io-util\\sicoobbatch.log.1.log");
		tfCaminhoArquivo.setBounds(71, 11, 688, 27);
		frame.getContentPane().add(tfCaminhoArquivo);
		tfCaminhoArquivo.setColumns(10);
		
		
		JButton btnDeployer = new JButton("Deployer");
		btnDeployer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VarreduraArvoreDiretorio.LocalizadorArquivo.varrerArvoreDiretorio("C:\\SisbrIDE\\apps\\JBoss\\", "*sws*.*");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeployer.setBounds(10, 49, 137, 27);
		frame.getContentPane().add(btnDeployer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 1032, 360);
		frame.getContentPane().add(scrollPane);
		
		txtConsole = new JTextArea();
		txtConsole.setFont(new Font("Consolas", Font.PLAIN, 18));
		txtConsole.setColumns(10);
		scrollPane.setViewportView(txtConsole);
		
		
	}	
	
	public void setLogMessage(String message){
		txtConsole.append(message + "\n");
		txtConsole.selectAll();
	}	
}
