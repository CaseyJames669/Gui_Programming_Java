import java.awt.BorderLayout; import javax.swing.*; import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*; import javax.swing.filechooser.*; import java.io.File;

public class missed913 extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JFileChooser myChooser;
	
	public missed913(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		pnlMain = new JPanel(); contentPane.add(pnlMain, BorderLayout.CENTER);
		
		File initDirectory = new File("C:\\users\\ficek\\Documents\\Classes");
		myChooser = new JFileChooser(initDirectory);
		FileNameExtensionFilter myTxtFilter =
				new FileNameExtensionFilter("Text or word Only","txt","docx");
		myChooser.setFileFilter(myTxtFilter);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.setActionCommand("openFile");
		btnOpenFile.addActionListener(this);
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setActionCommand("saveFile");
		btnSaveFile.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if ("openFile".equals(e.getActionCommand())){
			int btnChosen = myChooser.showOpenDialog(pnlMain);
			if (btnChosen == JFileChooser.APPROVE_OPTION){
				System.out.println("Directory: " + myChooser.getCurrentDirectory());
				System.out.println("File Choosen was: " + myChooser.getSelectedFile());
			}
			else if (btnChosen == JFileChooser.CANCEL_OPTION)
				System.out.println("No File was Chosen");
		}
		else if (btnChosen == JFileChooser.CANCEL_OPTION)
			System.out.println("No Directory chosen for saving");
	}


public static void main(String[] args){
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try { ExFileChv2 frame = new ExFileChv2();
				frame.setVisible(true);
			}catch (Exception e) {e.printStackTrace();
			}
		}
	});
}
}