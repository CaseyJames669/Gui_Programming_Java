import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.*; 

import java.awt.*;

import javax.swing.border.*;

import java.awt.event.*; 

import javax.swing.filechooser.*; 

import java.io.File;

public class ExFileCh extends JFrame {
	private JPanel contentPane;
	
	public ExFileCh(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		final JPanel pnlMain = new JPanel();
		contentPane.add(pnlMain, BorderLayout.CENTER);
		File initDirectory = new File("C:\\Users\\Casey\\Documents");
		final JFileChooser myChooser = new JFileChooser(initDirectory);
		
		FileNameExtensionFilter myTextFilter = 
				new FileNameExtensionFilter("Text or Word files only","txt","docx");
		myChooser.setFileFilter(myTextFilter);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int btnChosen = myChooser.showOpenDialog(pnlMain);
				if (btnChosen == JFileChooser.APPROVE_OPTION){
					System.out.println("Directory: " + myChooser.getCurrentDirectory());
					System.out.println("File chosen was: "+ myChooser.getSelectedFile());
				}
				else if(btnChosen == JFileChooser.CANCEL_OPTION)
					System.out.println("No file was Chosen");
			}
		});
		pnlMain.add(btnOpenFile);
		
		JButton btnSaveFile = new JButton("Save File");
			btnSaveFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myChooser.showSaveDialog(pnlMain);
					System.out.println("Directory chosen for saving was: " +
							myChooser.getCurrentDirectory());
				}
			});
			pnlMain.add(btnSaveFile);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { ExFileCh frame = new ExFileCh();
					frame.setVisible(true);
				}catch (Exception e) {e.printStackTrace();
				}
			}
		});
	}
	}
