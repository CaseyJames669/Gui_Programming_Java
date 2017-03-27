import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


public class SimpleTable extends JFrame {

	private JPanel contentPane;
	JTable myTable;
	
	public SimpleTable()
	{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100,100,450,300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5,5,5,5));
	contentPane.setLayout(new BorderLayout(0,0));
	setContentPane(contentPane);

	setLayout(new FlowLayout());
	String [] columnNames = {"Last Name", "First Name", "Age"};
	Object [][] data = {
			{"Smith", "Mary", 42},
			{"Jones", "Bob", 39},
			{"Johnson", "Shelley", 22}
	};
	
	myTable = new JTable(data,columnNames);
	myTable.setPreferredScrollableViewportSize(new Dimension(400,100));
	myTable.setFillsViewportHeight(true);
	JScrollPane myScroll = new JScrollPane(myTable);
	add(myScroll);	
	}
	
	
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleTable frame = new SimpleTable();
					frame.setVisible(true);
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}			
		});
	}

}
