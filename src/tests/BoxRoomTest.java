package tests;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;

public class BoxRoomTest {
@Test
	public void TestBoxRoomA() {
		// TODO Auto-generated method stub
		Rooms r1=new BoxRoom("Room A");
		Patient p1 = new Patient("Benoit");
		r1.displayPatientsInside();
		r1.newPatient(p1);
		
		r1.toString();
		
		
		
	}

}
