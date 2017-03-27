import java.awt.EventQueue; import java.awt.BorderLayout;
import javax.swing.JFrame; import javax.swing.JMenuBar; import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem; import java.awt.event.KeyEvent;


public class ExMenu extends JFrame {
	public ExMenu() {
		setTitle("Example of Creating Swing Menus");
		setSize(200,300);
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new BorderLayout());
		getContentPane().add(myPanel);

		JMenuBar menuBar = new JMenuBar();
		myPanel.add(menuBar,BorderLayout.NORTH);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menuFile);
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menuHelp);
		
		JMenuItem menuItemNew = new JMenuItem("New", KeyEvent.VK_N);
		menuFile.add(menuItemNew);
		JMenuItem menuItemOpen = new JMenuItem("Open", KeyEvent.VK_O);
		menuFile.add(menuItemOpen);
		JMenuItem menuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
		menuFile.add(menuItemSave);
		
		JMenuItem menuItemWelcome = new JMenuItem("Welcome");
		menuHelp.add(menuItemWelcome);
		JMenuItem menuItemAbout = new JMenuItem("About");
		menuHelp.add(menuItemAbout);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExMenu frame = new ExMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

