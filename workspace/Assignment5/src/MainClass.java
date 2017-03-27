 /*   Zach Bladow
      Assignment 5  -- Due Nov 13, 2012
      This program opens and saves a file in a comma delimeted format.  It also loads five images on the home screen
      You can add and print a list of customer in a linked list. You can also create orders if they have a matching 
      email in the linkedlist.  The program assigns the customer number automatically based on the last customer id entered.
      The program calculate a total for the customer purchasing books also. 
*/

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.Panel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class MainClass extends JFrame {
	// Declaring ints, linkedlists, and ect...
	int startIndex = 0;
	LinkedList customers = new java.util.LinkedList();
	LinkedList orders = new java.util.LinkedList();
	LinkedList books = new java.util.LinkedList();
	private JPanel contentPane;
	Order temp3 = new Order();
	Book temp2 = new Book();
	Customer temp = new Customer();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainClass() {
		// Adding books and authors to my linkedlist
		books.add("Hatchet");
		books.add("Gary Paulson");
		books.add("The Green Mile");
		books.add("Stephen King");
		books.add("A Child Called It");
		books.add("David J. Pelzer");
		books.add("50 Shades Of Grey");
		books.add("E.L. James");
		books.add("Twilight");
		books.add("Stephenie Meyer");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//Creating menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Creating menu
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);		
		
		//Menu open click
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		menuFile.add(menuOpen);		
	    menuOpen.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {   
	        	
	          //Opening the filechooser into the c:\\users folder with .txt files only
	          final JFileChooser fileopen = new JFileChooser("C:\\users");				             
              FileNameExtensionFilter myTxtFilter = new FileNameExtensionFilter("txt files only", "txt");
              fileopen.setFileFilter(myTxtFilter);         
                                             
              int ret = fileopen.showDialog(null, "Open file");
              if (ret == JFileChooser.APPROVE_OPTION) 
              {
                File file = fileopen.getSelectedFile();          
                 
                //Using a scanner to read in a file that is comma delimeted
          		Scanner scanner = null;
				try {
					scanner = new Scanner(new BufferedReader(new FileReader(file))).useDelimiter(",\\s|\\n");

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Reading the file in

				// reading through the file if it has another string
        		while(scanner.hasNext())
        		{		
        			String name = scanner.next();
        			
        			String[] testing = name.split("\\s+");
        			
        			// if string is greater then zero add it to the customer list
        			if(testing.length > 0) 
        			{
        				customers.add(testing[0].toString());
        		    }           
        		}
        		//System.out.println(customers);
              }
				
              else if(ret == JFileChooser.CANCEL_OPTION)
              {

              }
	          
	        	
	        }
	      });
		
		//DONE SAVING
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuFile.add(menuSave);
	    menuSave.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
	        {
	          System.out.println("Working");
	          
	          // choose where you would like to save the file
				JFileChooser saveFile = new JFileChooser();
				int ret = saveFile.showDialog(null, "Save File");   
				File file = saveFile.getSelectedFile();
				
				 try
				 {
					  // Create file 
					  FileWriter fstream = new FileWriter(file);
					  BufferedWriter out = new BufferedWriter(fstream);
					  for (int i = 0; i < customers.size(); i++ )
					  {
						  out.write(customers.get(i).toString() + ", ");
					  }
					  //Close the output stream
					  out.close();
				 }
				 
				 catch (Exception e1)
				 {//Catch exception if any
					 System.err.println("Error: " + e1.getMessage());
				 }
				
	        }
	      });
		
		//DONE MENUEXIT exiting the program
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		menuFile.add(menuExit);		
	    menuExit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          System.exit(0);
	        }
	      });
	    
		// adding jmenu customers
		JMenu menuCustomers = new JMenu("Customers");
		menuBar.add(menuCustomers);
		
		//DONE PRINTING CUSTOMERS
		JMenuItem menuCustomerPrint = new JMenuItem("Print");
		menuCustomers.add(menuCustomerPrint);
		menuCustomerPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				DefaultTableModel model = new DefaultTableModel(); 
				JTable table = new JTable(model); 

				// Create a couple of columns
				model.addColumn("Customer #");
				model.addColumn("FirstName");
				model.addColumn("LastName");
				model.addColumn("Street Address");
				model.addColumn("City");
				model.addColumn("State");
				model.addColumn("Zip");
				model.addColumn("Email");

				// Append a row  and add the customers info to the row
				for (int x = 0; x < customers.size(); x+=8)
				model.addRow(new Object[]{customers.get(x).toString(),customers.get(x+1).toString(),
										  customers.get(x+2).toString(),customers.get(x+3).toString(),
										  customers.get(x+4).toString(),customers.get(x+5).toString(),
										  customers.get(x+6).toString(),customers.get(x+7).toString()}); 
				
				JScrollPane myScroll2 = new JScrollPane(table);	
				
				// creating customer dialog
                JOptionPane.showMessageDialog(null, myScroll2);
			}
		});
		
		
		
		// DONE ADDING CUSTOMERS
		JMenuItem menuCustomerAdd = new JMenuItem("Add");
		menuCustomers.add(menuCustomerAdd);		
		menuCustomerAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{		
				//creating multiple textboxes
				final JTextField tb_FirstName;
				final JTextField tb_LastName;
				final JTextField tb_StreetAddress;
				final JTextField tb_City;
				final JTextField tb_State;
				final JTextField tb_ZipCode;
				final JTextField tb_Email;			
				
	        	 //Create a JPanel  
	        	 JPanel panel=new JPanel();  
	        	  
	        	 //Create a JFrame that we will use to add the JPanel  
	        	 JFrame frame=new JFrame("Create a JPanel");  
	        	  
	        	 //ADD JPanel INTO JFrame  
	        	 frame.getContentPane().add(panel);  
	        	  
	        	 panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	        	 //Set default close operation for JFrame  
	        	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	 
	        	// setting the textfields text
	     		tb_FirstName = new JTextField("First Name");

	    		tb_FirstName.setForeground(Color.black);
	    		
	    		tb_LastName = new JTextField("Last Name");
	    		tb_LastName.setForeground(Color.black);
	    		
	    		tb_StreetAddress = new JTextField("Street Address");
	    		tb_StreetAddress.setForeground(Color.black);
	    			
	    		tb_City = new JTextField("City");
	    		tb_City.setForeground(Color.black);

	    		tb_State = new JTextField("State");
	    		tb_State.setForeground(Color.black);

	    		tb_ZipCode = new JTextField("ZipCode");
	    		tb_ZipCode.setForeground(Color.black);
	    		
	    		tb_Email = new JTextField("Email");
	    		tb_Email.setForeground(Color.black);
	    		
	    		//adding textboxes to panel
	    		panel.add(tb_FirstName);
	    		panel.add(tb_LastName);
	    		panel.add(tb_StreetAddress);
	    		panel.add(tb_City);
	    		panel.add(tb_State);
	    		panel.add(tb_ZipCode);
	    		panel.add(tb_Email);
	    		
	    		// creating dialog
	    		JOptionPane.showMessageDialog(null, panel);
	    		
				temp.setFirstName(tb_FirstName.getText());
				temp.setLastName(tb_LastName.getText());
				temp.setStreetAddress(tb_StreetAddress.getText());
				temp.setCity(tb_City.getText());
				temp.setState(tb_State.getText());
				temp.setZip(tb_ZipCode.getText());
				temp.setEmail(tb_Email.getText());

	            int index = 0;

	            if (customers.size() > 0)
	            {
	            	index = customers.size() - 8;	
	            	startIndex = Integer.parseInt(customers.get(index).toString());	            	
	            }
	            
	            // getting all the variables for getter
	            customers.add(startIndex+1);  
	            customers.add(temp.getFirstName());
	            customers.add(temp.getLastName());
	            customers.add(temp.getStreetAddress());
	            customers.add(temp.getCity());
	            customers.add(temp.getState());
	            customers.add(temp.getZip());
	            customers.add(temp.getEmail());
	            
	            startIndex++;	
	    		
			}
		});
		
			
		JMenu menuOrders = new JMenu("Orders");
		menuBar.add(menuOrders);
		
		JMenuItem menuOrderPrint = new JMenuItem("Print");
		menuOrders.add(menuOrderPrint);
		menuOrderPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				DefaultTableModel model = new DefaultTableModel(); 
				JTable table = new JTable(model); 

				// Create a couple of columns
				model.addColumn("Customer #");
				model.addColumn("Title");
				model.addColumn("Qty");
				model.addColumn("Cover");
				model.addColumn("Shipping");
				model.addColumn("Total");

				// Append a row 
				for (int x = 0; x < orders.size(); x+=6)
				{
					model.addRow(new Object[]{orders.get(x).toString(),orders.get(x+1).toString(),
										  orders.get(x+2).toString(),orders.get(x+3).toString(),
										  orders.get(x+4).toString(),orders.get(x+5).toString(),}); 
				}
				
				JScrollPane myScroll2 = new JScrollPane(table);				
                JOptionPane.showMessageDialog(null, myScroll2);
            
                
			}
		});
		
		
		
		
		
		
		JMenuItem menuOrderAdd = new JMenuItem("Add");
		menuOrders.add(menuOrderAdd);
		menuOrderAdd.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
	        {	
	        	 //Create a JPanel  
	        	 JPanel panel=new JPanel();  
	        	  
	        	 //Create a JFrame that we will use to add the JPanel  
	        	 JFrame frame=new JFrame("Create a JPanel");  
	        	  
	        	 //ADD JPanel INTO JFrame  
	        	 frame.getContentPane().add(panel);  
	        	  
	        	 panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	        	 //Set default close operation for JFrame  
	        	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	 
	        	 JLabel lblBookStore = new JLabel("Zachs Used Books: Online Order From");
	        	 
	        	 final JLabel lblAuthor = new JLabel("Author:");
	        	
	        	boolean match = false;
	        	String customerNumber = null;
	        	
	        	String response = (String) (JOptionPane.showInputDialog(null, "Please Enter Your Email:", "Input Dialog",
	                    JOptionPane.QUESTION_MESSAGE, null, null, ""));
	        		
	        	//if (customers.contains(response))
	        	for (int i = 0; i < customers.size(); i++)	
	        	{	        	
	        		if(response.equals(customers.get(i).toString()))
	        		{	   
	        			match = true;      		
	        			customerNumber = (customers.get(i-7).toString());
	        		}     	
	        	}
	        	
	        	if (match == true)
	        	{	     
	        		panel.add(lblBookStore);
	        		temp3.setCustomerNum(customerNumber);
	        		
		    		// THIS IS THE COMBO BOX
		    		String course[] = {"Please Select One Of The Following","Hatchet","The Green Mile","A Child Called It","50 Shades Of Grey","Twilight"};		    		
		    		final JComboBox comboBox = new JComboBox(course);
		    		comboBox.setBackground(Color.white);
		    		comboBox.setForeground(Color.black);
		    		panel.add(comboBox);		
		    		panel.add(lblAuthor);
		    		
		    		comboBox.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent e) 
		                {
		                	// getting the title of the book and grabbing the author
		                	String title = comboBox.getSelectedItem().toString();
		                	for (int x = 0; x < books.size(); x++)
		    		    	{
		                		if (title.equals(books.get(x).toString()))
		    		    			{
		                				lblAuthor.setText("Author: " + books.get(x+1).toString());
		                				temp3.setTitle(books.get(x).toString());
		    		    			}
		    		    	}
		    			}
		    		});
		    		
		    		// Radio Buttons and grouping the buttons
		    		final JRadioButton rdbHardCover = new JRadioButton("Hard Cover");
		    		final JRadioButton rdbPaperBack = new JRadioButton("PaperBack");
		    		ButtonGroup group = new ButtonGroup();
		    		group.add(rdbHardCover);
		    		group.add(rdbPaperBack);
		    		panel.add(rdbHardCover);
		    		panel.add(rdbPaperBack);	

		    		
		        	// THIS IS THE SPINNER
		    		String months[] = {"Please Select One Of The Following","1","2","3","4","5","6","7","8","9","10"};
		    		SpinnerModel model = new SpinnerListModel(months);
		    		final JSpinner spinner = new JSpinner(model);   		   				    		
		    		panel.add(spinner);
		    		
		    		//this is the checkbox
		    		final JCheckBox chckbxNewCheckBox = new JCheckBox("2 Day Shipping");	
		    		panel.add(chckbxNewCheckBox);
		    		
		    		// button that calculates the total and shows you before submitting
		    		Button bt_CalculateTotal = new Button("Calculate Total");
		    		panel.add(bt_CalculateTotal);
		    		bt_CalculateTotal.addActionListener(new ActionListener() {
		    			public void actionPerformed(ActionEvent e) 
		    			{		    	
		    				int total = 0;
		    				int Qty = Integer.parseInt(spinner.getValue().toString());
		    				temp3.setQty(spinner.getValue().toString());
		    				
		    				if (rdbHardCover.isSelected())
		    				{		    					
		    					total = (Qty * 10);
		    					
		    					if (chckbxNewCheckBox.isSelected())
		    					{
		    						total += 2;
		    						temp3.setShipping("2 Day Shipping");
		    					}
		    					else
		    					{
		    						temp3.setShipping("Regular Shipping");
		    					}
		    					
		    					temp3.setCover("Hard Cover");
		    				}
		    				
		    				if (rdbPaperBack.isSelected())
		    				{
		    					total = (Qty * 5);
		    					
		    					if (chckbxNewCheckBox.isSelected())
		    					{
		    						total += 2;		    						
		    						temp3.setShipping("2 Day Shipping");
		    					}
		    					else
		    					{
		    						temp3.setShipping("Regular Shipping");
		    					}
		    					
		    					temp3.setCover("Paper Back");
		    				}
		    					    		
		    				JOptionPane.showMessageDialog(null, "$" + total + ".00"); 

		    				temp3.setTotal("$" + total + ".00");
		    			}	
		    		}); 		    		    	

		    		JOptionPane.showMessageDialog(null, panel);
		    		
    				int total = 0;
    				int Qty = Integer.parseInt(spinner.getValue().toString());
    				temp3.setQty(spinner.getValue().toString());
    				
    				// setting the books price depending what radio button is checked
    				if (rdbHardCover.isSelected())
    				{		    					
    					total = (Qty * 10);
    					
    					// adding shipping costs if checked
    					if (chckbxNewCheckBox.isSelected())
    					{
    						total += 2;
    						temp3.setShipping("2 Day Shipping");
    					}
    					else
    					{
    						temp3.setShipping("Regular Shipping");
    					}
    					
    					temp3.setCover("Hard Cover");
    				}
    				
    				if (rdbPaperBack.isSelected())
    				{
    					total = (Qty * 5);
    					
    					if (chckbxNewCheckBox.isSelected())
    					{
    						total += 2;		    						
    						temp3.setShipping("2 Day Shipping");
    					}
    					else
    					{
    						temp3.setShipping("Regular Shipping");
    					}
    					
    					temp3.setCover("Paper Back");
    				}
    					    		
    				JOptionPane.showMessageDialog(null, "$" + total + ".00"); 

    				temp3.setTotal("$" + total + ".00");
    				
    	        	orders.add(temp3.getCustomerNum());
    	        	orders.add(temp3.getTitle());
    	        	orders.add(temp3.getQty());
    	        	orders.add(temp3.getCover());
    	        	orders.add(temp3.getShipping());
    	        	orders.add(temp3.getTotal());
		    		
    	        	System.out.println(temp3.getCustomerNum() + " " + temp3.getTitle() + " " + temp3.getQty() + " " + temp3.getCover() + " " + temp3.getShipping() + " " + temp3.getTotal());
		    		
		    		
	        	}
	        	
	        	else
	        	{
	        		System.out.print("Matching email was Not Found"); 	        		
	        	}	        	
	        }
	        
	        
	    });		
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		//DONE THIS IS THE ABOUT CLICK (DONE)
		JMenuItem menuAbout = new JMenuItem("About");
		menuHelp.add(menuAbout);		
	    menuAbout.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
	        {	        		        	
	        	final ImageIcon icon = new ImageIcon("images/Zach.jpg");
	            JOptionPane.showMessageDialog(null, "Hello, My Name is Zach Bladow and I am the proud owner of the Joe Dirt Bookstore.\n  I founded the company on September 32, 1809 and it has been growing ever since.", "About", JOptionPane.INFORMATION_MESSAGE, icon);	
	        }
	      });
		
	    
	    
	    
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser saveFile = new JFileChooser();
				int ret = saveFile.showDialog(null, "Save File");   
				File file = saveFile.getSelectedFile();
				
				 try
				 {
					  // Create file 
					  FileWriter fstream = new FileWriter(file);
					  BufferedWriter out = new BufferedWriter(fstream);
					  for (int i = 0; i < customers.size(); i++ )
					  {
						  out.write(customers.get(i).toString() + ", ");
					  }
					  //Close the output stream
					  out.close();
				 }
				 
				 catch (Exception e1)
				 {//Catch exception if any
					 System.err.println("Error: " + e1.getMessage());
				 }
			}
		});
		
		
		btnSave.setToolTipText("Save");
		btnSave.setIcon(new ImageIcon(MainClass.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		toolBar.add(btnSave);
		
		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				final JFileChooser fileopen = new JFileChooser("C:\\users");				             
	              FileNameExtensionFilter myTxtFilter = new FileNameExtensionFilter("txt files only", "txt");
	              fileopen.setFileFilter(myTxtFilter);         
	                                             
	              int ret = fileopen.showDialog(null, "Open file");
	              if (ret == JFileChooser.APPROVE_OPTION) 
	              {
	                File file = fileopen.getSelectedFile();          
	                 
	          		Scanner scanner = null;
					try {
						scanner = new Scanner(new BufferedReader(new FileReader(file))).useDelimiter(",\\s|\\n");

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //Reading the file in

	        		while(scanner.hasNext())
	        		{		
	        			String name = scanner.next();
	        			
	        			String[] testing = name.split("\\s+");
	        			
	        			if(testing.length > 0) 
	        			{
	        				customers.add(testing[0].toString());
	        		    }           
	        		}
	        		//System.out.println(customers);
	              }
					
	              else if(ret == JFileChooser.CANCEL_OPTION)
	              {
	              }
			}
		});
		
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon(MainClass.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		toolBar.add(btnOpen);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblBook1 = new JLabel("");
		lblBook1.setIcon(new ImageIcon("images\\A_child_called_it.jpg"));
		panel.add(lblBook1);
		
		JLabel lblBook2 = new JLabel("");
		lblBook2.setIcon(new ImageIcon("images\\fiftyshades.png"));
		panel.add(lblBook2);
		
		JLabel lblBook3 = new JLabel("");
		lblBook3.setIcon(new ImageIcon("images\\greenmile.jpg"));
		panel.add(lblBook3);
		
		JLabel lblBook4 = new JLabel("");
		lblBook4.setIcon(new ImageIcon("images\\hatchet.jpg"));
		panel.add(lblBook4);
		
		JLabel lblBook5 = new JLabel("");
		lblBook5.setIcon(new ImageIcon("images\\twilightcover.jpg"));
		panel.add(lblBook5);
	}
}
