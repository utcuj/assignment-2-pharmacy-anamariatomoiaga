package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.MedicationController;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView window = new UserView();
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
	public UserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 377, 183);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(33, 27, 46, 14);
		frame.getContentPane().add(lblSearch);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String text = textField.getText();
					List<Object> med = MedicationController.searchName(text);
					Reflections r=new Reflections();
					JTable t=new JTable();
					t=r.createTable(med);
					JFrame frame = new JFrame("Medication");
				    frame.setSize(500,120);
				    frame.setLocationRelativeTo(null);
				    JPanel panel = new JPanel();
				    JScrollPane jsp = new JScrollPane(t);
				    panel.setLayout(new BorderLayout());
				    panel.add(jsp,BorderLayout.CENTER);
				    frame.setContentPane(panel);
				    frame.setVisible(true);
				}
			}
		});
		textField.setBounds(114, 24, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(33, 73, 46, 14);
		frame.getContentPane().add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 70, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(33, 113, 62, 14);
		frame.getContentPane().add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 110, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sell");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField_1.getText());
				int quantity = Integer.parseInt(textField_2.getText());
				MedicationController.updateQuantity(id, quantity);
			}
		});
		btnNewButton.setBounds(240, 69, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
