package fr.ecp.is1220.projet.part1;

import org.junit.Test;

public class BoxRoomTest {
@Test
	private void TestBoxRoomA() {
		// TODO Auto-generated method stub
		Rooms r1=new BoxRoom("Room A");
		Patient p1 = new Patient("Benoit");
		r1.displayPatientsInside();
		r1.newPatient(p1);
		
		r1.toString();
		
		
		
	}

}
