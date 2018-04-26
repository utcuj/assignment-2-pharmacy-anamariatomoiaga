import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;

import controller.MedicationController;
import controller.UserController;
import factory.FactoryReport;
import report.ReportGenerator;
import model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Medication m = new Medication("paracetamol","ass","ajjfdsd",50,15.0f);
		Medication m1 = new Medication("reuprofen","ass","ajjfdsd",50,15.0f);
		System.out.println(" =======CREATE =======");
		MedicationController.create(m);
		MedicationController.create(m1);*/
		/*System.out.println(" =======READ =======");
		List<Objects> med = MedicationController.read();
		for(Object x: med) {
			System.out.println(x.toString());
		}*/
		/*System.out.println(" =======DELETE ======= ");
		MedicationController.delete(5);*/
		//Medication m= new Medication(1,"paracetamol sinu1s","pp1","1ss",1020,215.3f);
		//MedicationController.update(m);
		
		/*int x = UserController.login("ana","ana",true);
		System.out.println(x);*/
		//MedicationController.updateQuantity(1, 4);
		//UserController.delete(4);
		/*List<Object> med = MedicationController.searchM();
		for(Object x: med) {
			System.out.println(x.toString());
		}
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
		}*/
}

}
