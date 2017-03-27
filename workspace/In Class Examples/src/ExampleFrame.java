import java.awt.*;
import javax.swing.*;

class ExampleFrame extends JFrame{
     public ExampleFrame()   //constructor
     {     setTitle("Frame Example 1"); //Title of the window
           setSize(200,300); //Size of the window
           JPanel myPanel = new JPanel();
           myPanel.setLayout(new BorderLayout());
           getContentPane().add(myPanel);
           // create labels and add them
           JLabel lblEast = new JLabel("Hello from the East"); //create
           JLabel lblNorth = new JLabel("Hello from the North"); //create
           myPanel.add(lblEast, BorderLayout.EAST); //add
           myPanel.add(lblNorth, BorderLayout.NORTH); //add
      }//end constructor

     public static void main(String args[ ])
     {     ExampleFrame myFrame = new ExampleFrame();
           myFrame.setVisible(true);
     }//end main
}//end class