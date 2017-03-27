import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.Label;
import javax.swing.JLabel;


public class SwingClass extends JFrame 
{
	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					SwingClass frame = new SwingClass();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */		
	public SwingClass() 
	{
//        JFrame frame = new JFrame("FrameDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		final JPanel panel = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Button bt_Inform = new Button("Inform");
		bt_Inform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog (null, "Testing Information icon");
			}
		});
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(bt_Inform);
		
		Button bt_Warning = new Button("Warning");
		bt_Warning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Testing Warning icon", "Invalid Input", JOptionPane.WARNING_MESSAGE);
			}
		});
		contentPane.add(bt_Warning);
		
		Button bt_Error = new Button("Error");
		bt_Error.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Testing Error icon", "File Not Found", JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(bt_Error);
		
		Button bt_Confirm = new Button("Confirm");
		bt_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] options = {"Yes, please", "No, thanks", "Cancel"};
				int response = JOptionPane.showOptionDialog(null, "Do you really want to quit?" , "End The Program?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
				
				if (response == JOptionPane.YES_OPTION) 
				{
					dispose();
				}
			}
		});
		contentPane.add(bt_Confirm);
		
		Button bt_Color = new Button("Color Chooser");
		bt_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                JColorChooser clr = new JColorChooser();
                Color color = clr.showDialog(panel, "Choose Color",
                        Color.white);
                contentPane.setBackground(color);
			}
		});
		contentPane.add(bt_Color);
		
		Button bt_File = new Button("File Open Chooser");
		bt_File.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                JFileChooser fileopen = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("c files", "c");
                fileopen.addChoosableFileFilter(filter);

                int ret = fileopen.showDialog(panel, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) 
                {
                    File file = fileopen.getSelectedFile();
                    System.out.println("Selected File: " + fileopen.getSelectedFile());
                }
			}
		});
		contentPane.add(bt_File);
		
		final JLabel lbl_label = new JLabel("Good Morning ");
		
		Button bt_Input = new Button("Input");
		bt_Input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String response = (String)JOptionPane.showInputDialog(null, "Whats your first name?:", "Input Dialog",
				                    JOptionPane.QUESTION_MESSAGE, null, null, "");
				
				if ((response != null) && (response.length() > 0)) 
				{
				    lbl_label.setText("Good Morning " + response + "!");
				    return;
				}
			}
		});
		contentPane.add(bt_Input);			
		
		contentPane.add(lbl_label);
	}
}




