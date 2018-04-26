package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MedicationController;
import factory.FactoryReport;
import report.ReportGenerator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminView {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 198);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Object> med = MedicationController.searchM();
				FactoryReport r = new FactoryReport("PDF");
				ReportGenerator rep = r.Report();
				try {
					rep.GenerateReport(med);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnPdf.setBounds(21, 98, 106, 23);
		frame.getContentPane().add(btnPdf);
		
		JButton btnCsv = new JButton("CSV");
		btnCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Object> med = MedicationController.searchM();
				FactoryReport r = new FactoryReport("CSV");
				ReportGenerator rep = r.Report();
				try {
					rep.GenerateReport(med);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCsv.setBounds(182, 98, 106, 23);
		frame.getContentPane().add(btnCsv);
		
		JButton btnMedication = new JButton("Medication");
		btnMedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				MedicationCRUD r= new MedicationCRUD();
		        r.frame.setVisible(true);
			}
		});
		btnMedication.setBounds(21, 38, 106, 23);
		frame.getContentPane().add(btnMedication);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				UserCRUD r= new UserCRUD();
		        r.frame.setVisible(true);
			}
		});
		btnUser.setBounds(182, 38, 106, 23);
		frame.getContentPane().add(btnUser);
	}

}
