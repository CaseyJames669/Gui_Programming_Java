import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.OBJ_ADAPTER;


public class SimpleTable2 extends JFrame {

	private JPanel contentPane;
	Object[][] data = null;
	String[] columnNames = new String[3];	
	private JTable tblEmployees;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				try
				{
					SimpleTable2 frame = new SimpleTable2();
					frame.setVisible(true);
				}
				catch(Exception e)
				{
				e.printStackTrace();				
				}
				
			}			
		});
	}	
	
	public SimpleTable2()
	{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100,100,450,300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5,5,5,5));
	contentPane.setLayout(new BorderLayout(0,0));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.WEST);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
	JButton btnAddEmployee = new JButton("Add Employee");
	btnAddEmployee.addActionListener(new ActionListener(){ 
	public void actionPerformed(ActionEvent e)
	{
		if (data==null)
		{
			data = new Object[1][3];
			data[0][0] = JOptionPane.showInputDialog("First Name");
			data[0][1] = JOptionPane.showInputDialog("Last Name");
			data[0][2] = JOptionPane.showInputDialog("Company");
			tblEmployees.setModel(new DefaultTableModel(data,columnNames));
		}
		
		else 
		{
			System.out.println("in the else part");
			Object[][] temp = new Object[data.length+1][3];
			for(int rowCT = 0; rowCT < data.length; rowCT++)
			{
				for (int colCT = 0; colCT < 3; colCT++)
				{
					temp[rowCT][colCT] = data[rowCT][colCT];					
				}
			}
			
			temp[data.length][0] = JOptionPane.showInputDialog("First Name");
			temp[data.length][1] = JOptionPane.showInputDialog("Last Name");
			temp[data.length][2] = JOptionPane.showInputDialog("Company");
			
			data = temp;
			tblEmployees.setModel(new DefaultTableModel(data,columnNames));
		}
	}
	});
	
	panel.add(btnAddEmployee);
	tblEmployees = new JTable();
	columnNames= new String[]{"First Name", "Last Name","Company"};
	
	tblEmployees.setModel(new DefaultTableModel(data,columnNames));
	contentPane.add(tblEmployees,BorderLayout.CENTER);
	}
}
