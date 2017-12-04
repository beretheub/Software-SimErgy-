package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.core.Strecher;

public class BoxRoomTest {
@Test
	public void TestBoxRoomA() {
		// TODO Auto-generated method stub
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		
		Rooms r1=new BoxRoom(ed1,"Room A");
		
		r1.setCapacity(2);
		r1.setName("Chambre de Benoit");
		r1.getCapacity();
		r1.getClass();
		r1.getEd();
		r1.getId();
		r1.getName();
		r1.getPatientsInside();
		r1.getType();
}
		
		@Test
		public void TestBoxRoomPatient() {
			EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
			
			Rooms r1=new BoxRoom(ed1,"Room A");
			Patient p1 = new Patient(ed1,"Benoit");
			
			r1.displayPatientsInside();
			try {
				r1.newPatient(p1);
			} catch (FullRoom e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			r1.toString();
			r1.notify();
			r1.removePatient(p1);
			
			

		
		
	}

}
