package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.MedicationController;
import model.Medication;

public class CreateMed {

	@Test
	public void test() {
		
		Medication m = new Medication("paracetamol","ass","ajjfdsd",50,15.0f);
		int x=MedicationController.create(m);
		assertTrue(x!=0);
	}

}
