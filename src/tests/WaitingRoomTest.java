package tests;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.WaitingRoom;

public class WaitingRoomTest {
@Test
	public void TestWaitingRoom1() {
		// TODO Auto-generated method stub
		WaitingRoom wr1=new WaitingRoom("WRA");
		
		wr1.setName("WRAA");
		Patient p1 = new Patient("Benoit");
		wr1.displayPatientsInside();
		wr1.newPatient(p1);
		wr1.getName();
		wr1.getId();
		wr1.toString();
		
		
		
		
	}

}
