package tests;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.Insurance;
import fr.ecp.is1220.projet.part1.core.Patient;

public class PatientTest {
	@Test
	public void testPatientBrigitte() {
		Patient p1=new Patient("Alfred");
		Patient p2= new Patient ("Brigitte",Insurance.GOLD) ;
		p1.toString();
		p2.toString();
		
		p1.setName("Brigitte");
		p1.setInsurance(Insurance.GOLD);
		p1.toString();
		p2.toString();
		
}
	
	
}
