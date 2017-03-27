import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Asmt extends JFrame {

	private JPanel contentPane;
	private JTextField employeeName;
	private JTextField hours;
	private JTextField payRate;
	private JTextField yearsWorked;
	private JTextField nameOutput;
	private JTextField hoursOutput;
	private JTextField payrateOutput;
	private JTextField yearsworkedOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Asmt frame = new Asmt();
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
	public Asmt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		panel.add(lblEmployeeName, "2, 2, right, default");
		
		employeeName = new JTextField();
		employeeName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		panel.add(employeeName, "4, 2, fill, default");
		employeeName.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		panel.add(lblHours, "2, 4, right, default");
		
		hours = new JTextField();
		panel.add(hours, "4, 4, fill, default");
		hours.setColumns(10);
		
		JLabel lblPayRate = new JLabel("Pay Rate");
		panel.add(lblPayRate, "2, 6, right, default");
		
		payRate = new JTextField();
		panel.add(payRate, "4, 6, fill, default");
		payRate.setColumns(10);
		
		JLabel lblYearsWorked = new JLabel("Years Worked");
		panel.add(lblYearsWorked, "2, 8, right, default");
		
		yearsWorked = new JTextField();
		panel.add(yearsWorked, "4, 8, fill, default");
		yearsWorked.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = employeeName.getText();
				String hrs = hours.getText();
				String pR = payRate.getText();
				String yW = yearsWorked.getText();
				nameOutput.setText(name);
				hoursOutput.setText(hrs);
				payrateOutput.setText(pR);
				yearsworkedOutput.setText(yW);
			}
		});
		panel.add(btnSubmit, "4, 10");
		
		JLabel lblEmployeeName_1 = new JLabel("Employee Name");
		panel.add(lblEmployeeName_1, "2, 12, right, default");
		
		nameOutput = new JTextField();
		nameOutput.setEditable(false);
		panel.add(nameOutput, "4, 12, fill, default");
		nameOutput.setColumns(10);
		
		JLabel lblHours_1 = new JLabel("Hours");
		panel.add(lblHours_1, "2, 14, right, default");
		
		hoursOutput = new JTextField();
		hoursOutput.setEditable(false);
		panel.add(hoursOutput, "4, 14, fill, default");
		hoursOutput.setColumns(10);
		
		JLabel lblPayRate_1 = new JLabel("Pay Rate");
		panel.add(lblPayRate_1, "2, 16, right, default");
		
		payrateOutput = new JTextField();
		payrateOutput.setEditable(false);
		panel.add(payrateOutput, "4, 16, fill, default");
		payrateOutput.setColumns(10);
		
		JLabel Years = new JLabel("Years Worked");
		panel.add(Years, "2, 18, right, default");
		
		yearsworkedOutput = new JTextField();
		yearsworkedOutput.setEditable(false);
		panel.add(yearsworkedOutput, "4, 18, fill, default");
		yearsworkedOutput.setColumns(10);
		
	}

}
