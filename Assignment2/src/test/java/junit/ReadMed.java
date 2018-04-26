package junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controller.MedicationController;

public class ReadMed {

	@Test
	public void test() {
		List<Object> med = MedicationController.read();
		assertTrue(med.size()!=0);
	}

}
