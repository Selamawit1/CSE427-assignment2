package saveScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Host;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveScreen {

	private JFrame frame;
	private Host host;

	/**
	 * Launch the application.
	 */
	public static void launchSaveScreen(Host host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveScreen window = new SaveScreen(host);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaveScreen(Host host) {
		this.host = host;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 492, 206);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton saveOne = new JButton("Save as Game One");
		saveOne.setBackground(SystemColor.menu);
		saveOne.setBounds(10, 47, 143, 65);
		saveOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.saveGame(1);
				frame.dispose();
			}
		});
		frame.getContentPane().add(saveOne);
		
		JButton saveTwo = new JButton("Save as Game Two");
		saveTwo.setBounds(166, 47, 143, 65);
		saveTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.saveGame(2);
				frame.dispose();
			}
		});
		frame.getContentPane().add(saveTwo);
		
		JButton saveThree = new JButton("Save as Game Three");
		saveThree.setBounds(323, 47, 143, 65);
		saveThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.saveGame(3);
				frame.dispose();
			}
		});
		frame.getContentPane().add(saveThree);
	}

}
