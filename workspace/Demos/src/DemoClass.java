import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.text.DateFormatSymbols;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DemoClass extends JFrame {

	JComboBox comboBox;
	String test;
	JSlider slider;
	JLabel lblSliderValue;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoClass frame = new DemoClass();
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
	public DemoClass(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		// THIS IS THE SPINNER
		//String[] months = new DateFormatSymbols().getMonths();
		String months[] = {"Please Select One Of The Following","Jan","Feb","Mar","April"};
		SpinnerModel model = new SpinnerListModel(months);
		final JSpinner spinner = new JSpinner(model);
		contentPane.add(spinner);				
		String value = spinner.getValue().toString();			
		final JLabel spinnerSelected = new JLabel("Month = ");
		contentPane.add(spinnerSelected);		
		
		String course[] = {"Please Select One Of The Following","Monday","Tuesday","Wednesday","Thursday","Friday"};		
		
		slider = new JSlider();
		contentPane.add(slider);
		
		lblSliderValue = new JLabel("Slider Value = ");
		contentPane.add(lblSliderValue);
		
		// THIS IS THE COMBO BOX
		comboBox = new JComboBox(course);
		comboBox.setBackground(Color.gray);
		comboBox.setForeground(Color.red);
		contentPane.add(comboBox);
		
		final String value3 = (String) comboBox.getSelectedItem();	
		
		final JLabel lblDay = new JLabel("Day Of The Week =");
		contentPane.add(lblDay);

		
				
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String value = spinner.getValue().toString();
				spinnerSelected.setText("Month = " + value);
				
				String value3 = (String) comboBox.getSelectedItem();	
				lblDay.setText("Day Of The Week = " + value3);
			}
		});		
		
		contentPane.add(btnSubmit);	
		
		
		
		 slider.addChangeListener(new ChangeListener() 
		 {
	            @Override
	            public void stateChanged(ChangeEvent e) 
	            {
	            	String value2 = String.valueOf(slider.getValue());
	                //label.setText(String.valueOf(slider.getValue()));
	            	lblSliderValue.setText("Slider Value = " + value2);
	            }
	        });	
	}
}

// SPINNER, COMBO BOX, SLIDER