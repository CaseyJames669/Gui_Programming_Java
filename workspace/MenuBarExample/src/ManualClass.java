import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ManualClass extends JPanel
{
	public ManualClass()
	{
		setLayout(new BorderLayout());
		setVisible(false);
		setOpaque(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	}
	
	protected void paintComponent(Graphics g)
	{
		Color bgColor = getBackground();
		get.setColor(new Color(bgColor.getRed())),
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
