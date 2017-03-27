import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Caret;


public class EmployeeGuiClass extends JFrame implements ActionListener
{	
		Employee temp = new Employee();
	
		protected JLabel lb_Employee;
		protected JLabel lb_FirstName;
		protected JLabel lb_LastName;
		protected JLabel lb_Salary;
		protected JLabel lb_YrsWorked;

		protected JTextField tb_FirstName;
		protected JTextField tb_LastName;
		protected JTextField tb_Salary;
		protected JTextField tb_YrsWorked;
		
		protected JTextArea ta_Console;
		protected JTextArea ta_Console2;
		
		protected JButton bt_Submit;
		protected JButton bt_Summarize;	
		
		double zero = 0;
		double zero2 = 0;
		double total = 0;
		double high = 0;
		double low = 0;
		int count = 0;
		
		EmployeeGuiClass()
		{						
			initGUI();
		}
		
		public final void initGUI()
		{
			setSize(700,700);
			setTitle("Testing");
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());		
			
			JPanel pnlTop = new JPanel();
			pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.PAGE_AXIS));	
			
			JPanel pnlBottom = new JPanel();
			pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.LINE_AXIS));			
			
			JLabel First = new JLabel("First Name");
			JLabel emp = new JLabel("Employee");
			
			tb_FirstName = new JTextField("First Name");
			tb_FirstName.setForeground(Color.black);
			
			tb_LastName = new JTextField("Last Name");
			tb_LastName.setForeground(Color.black);
			
			tb_Salary = new JTextField("Salary");
			tb_Salary.setForeground(Color.black);
				
			tb_YrsWorked = new JTextField("Years Worked");
			tb_YrsWorked.setForeground(Color.black);
			
			ta_Console = new JTextArea("Console");
			ta_Console2 = new JTextArea("Summary");
							
			bt_Submit = new JButton("Submit");
			bt_Submit.setActionCommand("submitResults");
			bt_Submit.addActionListener(this);
			
			bt_Summarize = new JButton("Summarize");
			bt_Summarize.setActionCommand("summarizeResults");
			bt_Summarize.addActionListener(this);			
			
			pnlTop.add(emp);
			pnlTop.add(tb_FirstName);
			pnlTop.add(tb_LastName);
			pnlTop.add(tb_Salary);
			pnlTop.add(tb_YrsWorked);
			pnlTop.add(ta_Console);
			
			pnlBottom.add(ta_Console2);
			pnlBottom.add(bt_Submit);
			pnlBottom.add(bt_Summarize);
			
			add(pnlTop,BorderLayout.NORTH);
			add(pnlBottom,BorderLayout.SOUTH);			
		}
		
		
	public void actionPerformed(ActionEvent e)
	{
		if ("submitResults".equals(e.getActionCommand()))
		{
			temp.setFirstName(tb_FirstName.getText());
			temp.setLastName(tb_LastName.getText());			
			temp.setSalary(Integer.parseInt(tb_Salary.getText()));
			temp.setYrsWorked(Integer.parseInt(tb_YrsWorked.getText()));
			
			ta_Console.setText("First Name: " + temp.getFirstName() + "\tLast Name: " + temp.getLastName() +"\tSalary: " + temp.getSalary() + "\tYears Worked: " + temp.getYrsWorked());
			
			if (count == 0)
			{
				zero2 = temp.getSalary();
				low = temp.getSalary();
			}
			
			total = total + temp.getSalary();
			count++;
			
			if (temp.getSalary() > high)
			{
				high = temp.getSalary();
				zero = temp.getSalary();
			}
			
			if (temp.getSalary() < zero2)
			{
				low = temp.getSalary();
				zero2 = temp.getSalary();
			}			
			
			tb_FirstName.setText("");
			tb_LastName.setText("");
			tb_Salary.setText("");
			tb_YrsWorked.setText("");
			
			tb_FirstName.requestFocusInWindow();
		}
		
		if ("summarizeResults".equals(e.getActionCommand()))
		{
			total = total/count;
						
			ta_Console2.setText("Average: " + total + " " + "Highest: " + high + " " + "Lowest: " + low);
		}
	}		
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				EmployeeGuiClass employeeGUI = new EmployeeGuiClass();
				employeeGUI.setVisible(true);
			}
		});
	}

}
