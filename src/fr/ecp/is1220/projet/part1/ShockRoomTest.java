package fr.ecp.is1220.projet.part1;

import org.junit.Test;

public class ShockRoomTest {
@Test
	private void TestShockRoom1() {
		// TODO Auto-generated method stub
		ShockRoom cr1=new ShockRoom("WRA");
		
		cr1.setName("WRAA");
		Patient p1 = new Patient("Benoit");
		cr1.displayPatientsInside();
		cr1.newPatient(p1);
		cr1.getName();
		cr1.getId();
		cr1.toString();
		
		
		
		
	}

}
