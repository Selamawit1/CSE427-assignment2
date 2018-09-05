package errorMessage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import utilities.Date;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorMessage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textField;
	String message;

	/**
	 * Launch the application.
	 */
	public static void launchErrorMessage(String message) {
		try {
			ErrorMessage dialog = new ErrorMessage(message);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErrorMessage(String message) {
		setBounds(100, 100, 455, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextArea();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField.setBounds(0, 0, 439, 80);
			textField.setText(message);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
	}

}
