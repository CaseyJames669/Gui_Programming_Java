import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class LayoutExample extends JFrame 
{
	public LayoutExample()
	{
		initGUI();
	}

	public final void initGUI() 
	{
		setSize(300,250);
		setTitle("Example: Flow Layout");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new FlowLayout());
		
		JButton btnOne = new JButton("One");
		JButton btnTwo = new JButton("Two");
		JButton btnThree = new JButton("Three");
		JButton btnFour = new JButton("Four");
		JButton btnFive = new JButton("Five");
		
		pnlMain.add(btnOne);
		pnlMain.add(btnTwo);
		pnlMain.add(btnThree);
		pnlMain.add(btnFour);
		pnlMain.add(btnFive);
		
		add(pnlMain);				
	}

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				LayoutExample example1 = new LayoutExample();
				example1.setVisible(true);
			}
		});
	}
}
