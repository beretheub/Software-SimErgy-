package fr.ecp.is1220.projet.part1;

import org.junit.Test;

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
