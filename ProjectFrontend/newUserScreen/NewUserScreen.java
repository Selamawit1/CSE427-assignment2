package newUserScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Host;
import utilities.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import errorMessage.ErrorMessage;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewUserScreen {

	private JFrame frame;
	private Host host;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;
	private JTextField password;
	private JTextField email;
	private JTextField month;
	private JTextField day;
	private JTextField year;
	private JTextField pathToProPic;

	/**
	 * Launch the application.
	 */
	public static void launchNewUserScreen(Host host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserScreen window = new NewUserScreen(host);
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
	public NewUserScreen(Host host) {
		this.host = host;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 453, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(169, 56, 220, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(169, 87, 220, 20);
		frame.getContentPane().add(lastName);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(169, 118, 220, 20);
		frame.getContentPane().add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(169, 149, 220, 20);
		frame.getContentPane().add(password);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(169, 180, 220, 20);
		frame.getContentPane().add(email);
		
		month = new JTextField();
		month.setColumns(10);
		month.setBounds(169, 242, 43, 20);
		frame.getContentPane().add(month);
		
		JLabel lblNewLabel = new JLabel("Welcome to DanBook");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(43, 59, 116, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(43, 90, 116, 17);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(43, 152, 116, 17);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(43, 121, 116, 17);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setBounds(43, 245, 116, 17);
		frame.getContentPane().add(lblBirthday);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(43, 183, 116, 17);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(169, 264, 43, 17);
		frame.getContentPane().add(lblMonth);
		
		day = new JTextField();
		day.setColumns(10);
		day.setBounds(222, 242, 43, 20);
		frame.getContentPane().add(day);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(222, 264, 43, 17);
		frame.getContentPane().add(lblDay);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(275, 242, 64, 20);
		frame.getContentPane().add(year);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(275, 264, 64, 17);
		frame.getContentPane().add(lblYear);
		
		pathToProPic = new JTextField();
		pathToProPic.setColumns(10);
		pathToProPic.setBounds(169, 211, 220, 20);
		frame.getContentPane().add(pathToProPic);
		
		JLabel lblPathToProfile = new JLabel("Path to Profile Picture");
		lblPathToProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblPathToProfile.setBounds(43, 214, 116, 17);
		frame.getContentPane().add(lblPathToProfile);
		
		JButton create = new JButton("Create New Account!");
		create.setBackground(SystemColor.window);
		create.setBounds(158, 288, 152, 23);
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				if(!firstName.getText().equals("") && !lastName.getText().equals("")) {
					Date birthday = !month.getText().equals("") && !day.getText().equals("") && !year.getText().equals("") ? 
							new Date (Integer.parseInt(month.getText()), Integer.parseInt(day.getText()), Integer.parseInt(year.getText())) : null;
					host.createNewUser(firstName.getText(), lastName.getText(), username.getText(), password.getText(), email.getText(), pathToProPic.getText(), birthday);
					frame.dispose();
				}else {
					ErrorMessage.launchErrorMessage("Enter a first and last name. All other credentials can be set later.");
				}
			}
		});
		frame.getContentPane().add(create);
	}
}
