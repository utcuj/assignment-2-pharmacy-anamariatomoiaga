package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.UserController;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(34, 58, 79, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 124, 64, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(168, 55, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 121, 86, 20);
		frame.getContentPane().add(passwordField);
		
		final JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(248, 193, 109, 23);
		frame.getContentPane().add(rdbtnAdmin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u = textField.getText();
				String p = String.valueOf(passwordField.getPassword());
				if(rdbtnAdmin.isSelected()) {
					int i = UserController.login(u, p, true);
					if(i!=-1) {
						frame.setVisible(false);
						AdminView r= new AdminView();
				        r.frame.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Username or password incorect");
				}
				else {
					int i = UserController.login(u, p, false);
					if(i!=-1) {
						frame.setVisible(false);
						UserView r= new UserView();
				        r.frame.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Username or password incorect");
				}
			}
		});
		btnLogin.setBounds(86, 193, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		
	}
}
