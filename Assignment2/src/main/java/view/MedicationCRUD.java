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
import model.Medication;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MedicationCRUD {

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
					MedicationCRUD window = new MedicationCRUD();
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
	public MedicationCRUD() {
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
		lblId.setBounds(22, 27, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 58, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblIngredients = new JLabel("Ingredients");
		lblIngredients.setBounds(22, 94, 70, 14);
		frame.getContentPane().add(lblIngredients);
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		lblManufacturer.setBounds(22, 132, 85, 14);
		frame.getContentPane().add(lblManufacturer);
		
		JLabel lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setBounds(22, 164, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(22, 200, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(138, 24, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 55, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 88, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 129, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(138, 161, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(138, 197, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_1.getText();
				String ingredients = textField_2.getText();
				String manufacturer = textField_3.getText();
				int quantity = Integer.parseInt(textField_4.getText());
				float price = Float.parseFloat(textField_5.getText());
				Medication m = new Medication(name,manufacturer,ingredients,quantity,price);
				MedicationController.create(m);
			}
		});
		btnCreate.setBounds(261, 23, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				String ingredients = textField_2.getText();
				String manufacturer = textField_3.getText();
				int quantity = Integer.parseInt(textField_4.getText());
				float price = Float.parseFloat(textField_5.getText());
				Medication m = new Medication(id,name,manufacturer,ingredients,quantity,price);
				MedicationController.update(m);
			}
		});
		btnUpdate.setBounds(261, 65, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Object> med = MedicationController.read();
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
		});
		btnRead.setBounds(261, 110, 89, 23);
		frame.getContentPane().add(btnRead);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				MedicationController.delete(id);
			}
		});
		btnDelete.setBounds(261, 155, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				AdminView r= new AdminView();
		        r.frame.setVisible(true);
			}
		});
		btnBack.setBounds(261, 196, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
