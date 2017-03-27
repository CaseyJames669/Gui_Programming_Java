import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/* FrameDemo.java requires no other files. */
public class FrameDemo extends JPanel 
{
	public FrameDemo() {
	}
    private static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
 

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu menu = new JMenu("File");
        menubar.add(menu);
        menu.add("Open");
        menu.add("Save");
        
        JToolBar toolbar = new JToolBar();
        frame.getContentPane().add(toolbar, BorderLayout.NORTH);
        toolbar.add(new JButton("Toolbar Button"));
        
        JLabel label = new JLabel ("Im content but a little blue.");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(300, 160));
        label.setBackground(new Color(197, 216, 236));
        label.setOpaque(true);
        frame.getContentPane().add(label);
           
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
               
        
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}