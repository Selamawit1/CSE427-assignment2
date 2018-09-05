package loadScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Host;

import java.awt.Font;

public class LoadScreen {

	private JFrame frame;
	private JTextField txtLoadGame;
	private Host host;

	/**
	 * Launch the application.
	 */
	public static void launchLoadScreen(Host host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadScreen window = new LoadScreen(host);
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
	public LoadScreen(Host host) {
		this.host = host;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton gameOne = new JButton("Game 1");
		gameOne.setBounds(256, 47, 114, 53);
		gameOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// load game one from file
				host.loadGame(1);
				frame.dispose();
			}
		});
		frame.getContentPane().add(gameOne);
		
		JButton gameTwo = new JButton("Game 2");
		gameTwo.setBounds(256, 111, 114, 53);
		gameTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// load game two from file
				host.loadGame(2);
				frame.dispose();
			}
		});
		frame.getContentPane().add(gameTwo);
		
		JButton gameThree = new JButton("Game 3");
		gameThree.setBounds(256, 175, 114, 53);
		gameThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// load game three from file
				host.loadGame(3);
				frame.dispose();
			}
		});
		frame.getContentPane().add(gameThree);
		
		JButton createNewGame = new JButton("Create New Game");
		createNewGame.setBounds(48, 103, 166, 53);
		createNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// load game three from file
				host.newGame();
				frame.dispose();
			}
		});
		frame.getContentPane().add(createNewGame);
		
		txtLoadGame = new JTextField();
		txtLoadGame.setBorder(null);
		txtLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLoadGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoadGame.setBackground(SystemColor.activeCaption);
		txtLoadGame.setEditable(false);
		txtLoadGame.setText("Load Game");
		txtLoadGame.setBounds(10, 11, 414, 25);
		frame.getContentPane().add(txtLoadGame);
		txtLoadGame.setColumns(10);
	}

}
