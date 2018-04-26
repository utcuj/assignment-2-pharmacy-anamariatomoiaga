package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.UserController;
import model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UserCRUD {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCRUD window = new UserCRUD();
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
	public UserCRUD() {
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
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(23, 37, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(23, 69, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(23, 106, 66, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(23, 140, 66, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(23, 175, 66, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(23, 208, 46, 14);
		frame.getContentPane().add(lblAdmin);
		
		textField = new JTextField();
		textField.setBounds(121, 34, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 66, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 103, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 137, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 172, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(121, 205, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_1.getText();
				String address = textField_2.getText();
				String username = textField_3.getText();
				String password = textField_4.getText();
				boolean admin = Boolean.parseBoolean(textField_5.getText());
				User u = new User(name,address,username,password,admin);
				UserController.create(u);
			}
		});
		btnCreate.setBounds(268, 33, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Read");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Object> med = UserController.read();
				Reflections r=new Reflections();
				JTable t=new JTable();
				t=r.createTable(med);
				JFrame frame = new JFrame("User");
			    frame.setSize(500,120);
			    frame.setLocationRelativeTo(null);
			    JPanel panel = new JPanel();
			    JScrollPane jsp = new JScrollPane(t);
			    panel.setLayout(new BorderLayout());
			    panel.add(jsp,BorderLayout.CENTER);
			    frame.setContentPane(panel);
			    frame.setVisible(true);
			}
		});
		btnUpdate.setBounds(268, 79, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				String address = textField_2.getText();
				boolean admin = Boolean.parseBoolean(textField_5.getText());
				UserController.update(id, name, address, admin);
			}
		});
		btnUpdate_1.setBounds(268, 125, 89, 23);
		frame.getContentPane().add(btnUpdate_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				UserController.delete(id);
			}
		});
		btnDelete.setBounds(268, 166, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				AdminView r= new AdminView();
		        r.frame.setVisible(true);
			}
		});
		btnBack.setBounds(268, 204, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
