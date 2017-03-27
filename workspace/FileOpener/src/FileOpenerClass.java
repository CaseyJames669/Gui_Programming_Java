import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;


public class FileOpenerClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileOpenerClass frame = new FileOpenerClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileOpenerClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		final Label lblDirectory = new Label("Directory Chosen: ");
		final Label lblFile = new Label("File Chosen: ");
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				final JFileChooser fileopen = new JFileChooser("C:\\users");				             
                FileNameExtensionFilter myTxtFilter = new FileNameExtensionFilter("image files only", "jpeg","gif");
                fileopen.setFileFilter(myTxtFilter);         
                                               
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) 
                {
                    File file = fileopen.getSelectedFile();
                    lblDirectory.setForeground(Color.BLACK);
                	lblFile.setForeground(Color.BLACK);
                    lblDirectory.setText("Directory Chosen: " + fileopen.getCurrentDirectory());
                    lblFile.setText("File Chosen: " + fileopen.getSelectedFile());
                }
				
                else if(ret == JFileChooser.CANCEL_OPTION)
                {
                	lblDirectory.setForeground(Color.RED);
                	lblFile.setForeground(Color.RED);
                	lblDirectory.setText("Directory Chosen: NO FILE CHOSEN");
                    lblFile.setText("File Chosen: NO FILE CHOSEN");
                }
                	
			}
		});
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(btnOpenFile);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser saveFile = new JFileChooser();
				int ret = saveFile.showDialog(null, "Save File");
			}
		});
		panel_1.add(btnSaveFile);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2.add(lblDirectory);
		panel_2.add(lblFile);
	}
}
