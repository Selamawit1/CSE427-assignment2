package loginScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Host;

public class LoginScreen {

	private JFrame frame;
	private Host host;
	private JTextField txtPassword;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void LaunchLoginScreen (Host host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen(host);
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
	public LoginScreen(Host host) {
		this.host = host;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		addImage();
		addConstTextFields();
		addMutableTextFields();
		addButtons();
	}
	
	private void addImage() {
		javaxt.io.Image ii = new javaxt.io.Image("Pictures/Dan.JPG");
		ii.resize(700, 700, true);
		ii.rotate(90);
	    JLabel label = new JLabel(new ImageIcon(ii.getImage()));
	    JPanel jsp = new JPanel();
	    jsp.add(label);
	    jsp.setBounds(891, 279, 650, 650);
	    frame.getContentPane().add(jsp);  
	}
	
	private void addMutableTextFields() {
		this.txtUsername = new JTextField();
	    txtUsername.setBounds(587, 482, 208, 30);
	    frame.getContentPane().add(txtUsername);
	    txtUsername.setColumns(10);
		
	    this.txtPassword = new JTextField();
	    txtPassword.setColumns(10);
	    txtPassword.setBounds(587, 531, 208, 30);
	    frame.getContentPane().add(txtPassword);
	}
	
	private void addButtons() {
		JButton newUser = new JButton("New User");
	    newUser.setBackground(SystemColor.textHighlightText);
	    newUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    newUser.setBounds(499, 740, 172, 42);
	    newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.toCreateNewUser();
				frame.dispose();
			}
		});
	    frame.getContentPane().add(newUser);
	    
	    JButton login = new JButton("Login");
	    login.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    login.setBackground(Color.WHITE);
	    login.setBounds(499, 572, 172, 42);
	    login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// login
				host.login(txtUsername.getText(), txtPassword.getText());
				frame.dispose();
			}
		});
	    frame.getContentPane().add(login);
	}
	
	private void addConstTextFields() {
		JTextField txtComeCreateA = new JTextField();
	    txtComeCreateA.setHorizontalAlignment(SwingConstants.CENTER);
	    txtComeCreateA.setForeground(SystemColor.desktop);
	    txtComeCreateA.setBorder(null);
	    txtComeCreateA.setText("Come Create a New World with Us");
	    txtComeCreateA.setBackground(SystemColor.activeCaption);
	    txtComeCreateA.setEditable(false);
	    txtComeCreateA.setFont(new Font("Wide Latin", Font.ITALIC, 24));
	    txtComeCreateA.setBounds(10, 231, 1884, 37);
	    frame.getContentPane().add(txtComeCreateA);
	    txtComeCreateA.setColumns(10);
	    
	    JTextField txtWelcomeToDanbook = new JTextField();
	    txtWelcomeToDanbook.setBorder(null);
	    txtWelcomeToDanbook.setForeground(SystemColor.desktop);
	    txtWelcomeToDanbook.setEditable(false);
	    txtWelcomeToDanbook.setFont(new Font("Wide Latin", Font.PLAIN, 60));
	    txtWelcomeToDanbook.setHorizontalAlignment(SwingConstants.CENTER);
	    txtWelcomeToDanbook.setText("Welcome to The DanBook");
	    txtWelcomeToDanbook.setBackground(SystemColor.activeCaption);
	    txtWelcomeToDanbook.setBounds(10, 22, 1884, 359);
	    frame.getContentPane().add(txtWelcomeToDanbook);
	    txtWelcomeToDanbook.setColumns(10);
	    
	    JTextField txtUsername = new JTextField();
	    txtUsername.setText("Username");
	    txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
	    txtUsername.setForeground(Color.BLACK);
	    txtUsername.setFont(new Font("Wide Latin", Font.ITALIC, 24));
	    txtUsername.setEditable(false);
	    txtUsername.setColumns(10);
	    txtUsername.setBorder(null);
	    txtUsername.setBackground(SystemColor.activeCaption);
	    txtUsername.setBounds(364, 480, 213, 30);
	    frame.getContentPane().add(txtUsername);
	    
	    JTextField txtPassword = new JTextField();
	    txtPassword.setText("Password");
	    txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
	    txtPassword.setForeground(Color.BLACK);
	    txtPassword.setFont(new Font("Wide Latin", Font.ITALIC, 24));
	    txtPassword.setEditable(false);
	    txtPassword.setColumns(10);
	    txtPassword.setBorder(null);
	    txtPassword.setBackground(SystemColor.activeCaption);
	    txtPassword.setBounds(364, 531, 213, 30);
	    frame.getContentPane().add(txtPassword);
	    
	    JTextField txtCreateANew = new JTextField();
	    txtCreateANew.setText("Create a New Account");
	    txtCreateANew.setHorizontalAlignment(SwingConstants.LEFT);
	    txtCreateANew.setForeground(Color.BLACK);
	    txtCreateANew.setFont(new Font("Wide Latin", Font.ITALIC, 20));
	    txtCreateANew.setEditable(false);
	    txtCreateANew.setColumns(10);
	    txtCreateANew.setBorder(null);
	    txtCreateANew.setBackground(SystemColor.activeCaption);
	    txtCreateANew.setBounds(396, 699, 374, 30);
	    frame.getContentPane().add(txtCreateANew);
	}
}
