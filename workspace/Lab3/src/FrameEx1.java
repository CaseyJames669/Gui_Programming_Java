import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEx1 extends JPanel implements ActionListener{
		
		//declaration of components
		protected static JButton btnChangeColor, btnNeutralColor;
		
		//constructor
		public FrameEx1(){
			setSize(300,500);
			btnChangeColor = new JButton("Change Panel Color");
			add(btnChangeColor); //add the button to the panel
			btnChangeColor.addActionListener(this);
			btnChangeColor.setActionCommand("changeColor");
			add(btnChangeColor);
			
			btnNeutralColor = new JButton("Back to Neutral");
			btnNeutralColor.addActionListener(this);
			btnNeutralColor.setActionCommand("neutralColor");
			add(btnNeutralColor);
			
		}//end constructor
		
		private static void createGUI() {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame myFrame = new JFrame("Frame demo");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create and set up the content pane
		FrameEx1 myContentPane = new FrameEx1();
		myContentPane.setOpaque(true);
		myFrame.setContentPane(myContentPane);
		
		myFrame.setSize(200,300);
		myFrame.setVisible(true);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("changeColor")){
			setBackground(Color.blue);
		}
		else if (e.getActionCommand().equals("neutralColor")){
			setBackground(Color.lightGray);
		}
	}
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createGUI();
			}//end run
		});//end invokeLater
	}//end main
}//end class FrameEx1
