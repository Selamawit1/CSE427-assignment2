package userScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Host;

public class EditProfilePicture extends JFrame {

	private JPanel contentPane;
	private Host host;

	/**
	 * Launch the application.
	 */
	public static void launchEditProfilePicture(Host host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfilePicture frame = new EditProfilePicture(host);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditProfilePicture(Host host) {
		this.host = host;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
