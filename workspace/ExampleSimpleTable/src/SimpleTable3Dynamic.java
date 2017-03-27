import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class SimpleTable3Dynamic extends JFrame {

	private JPanel contentPane;
	private JTextField txtCompany;
	private JTextField txtFName;
	private JTextField txtLName;
	private JLabel lblLName;
	private JLabel lblCompany;
	private JLabel lblFName;
	private JTextArea txtArea;
	private JButton btnAdd;

	ArrayList<ArrayList<String>> myData = new ArrayList<ArrayList<String>>();	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleTable3Dynamic frame = new SimpleTable3Dynamic();
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
	public SimpleTable3Dynamic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		lblFName = new JLabel("First Name");
		panel.add(lblFName);
		
		txtFName = new JTextField();
		panel.add(txtFName);
		txtFName.setColumns(10);
		
		lblLName = new JLabel("Last Name");
		panel.add(lblLName);
		
		txtLName = new JTextField();
		panel.add(txtLName);
		txtLName.setColumns(10);
		
		lblCompany = new JLabel("Company");
		panel.add(lblCompany);
		
		txtCompany = new JTextField();
		panel.add(txtCompany);
		txtCompany.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String tmpFName = txtFName.getText();
				String tmpLName = txtLName.getText();
				String tmpCompany = txtCompany.getText();
				
				ArrayList<String> tmpRow = new ArrayList<String>();
				tmpRow.add(tmpFName);
				tmpRow.add(tmpLName);
				tmpRow.add(tmpCompany);
				
				txtFName.setText(" ");
				txtLName.setText(" ");
				txtCompany.setText(" ");
				txtFName.requestFocus();
				
				myData.add(tmpRow);
				
				for (ArrayList<String> oneRow : myData)
				{
					for (int colCt = 0; colCt < oneRow.size(); colCt++)
					{
						System.out.println(oneRow.get(colCt) + "\t");
					}					
				}
				
				txtArea.setText(" ");
				for(ArrayList<String> myRow : myData)
				{
					for (int colCt = 0; colCt < myRow.size(); colCt++)
					{
						txtArea.append(myRow.get(colCt)+"\t");
					}
				}
				txtArea.append("\n");
			}
		});
		panel.add(btnAdd);
		
		txtArea = new JTextArea();
		contentPane.add(txtArea, BorderLayout.CENTER);
	}

}
