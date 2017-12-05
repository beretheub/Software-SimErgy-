package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;
import org.junit.runners.JUnit4;

import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.WaitingRoom;
import junit.framework.Assert;
import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Rooms;

public class WaitingRoomTest {
	@Test
	public void TestWaitingRoomA() {
		
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		
		Rooms r1=new WaitingRoom(ed1,"Room A");
		
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
	public void TestPrintPatientInsideifThereIsAPatient() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");

		Rooms r1=new WaitingRoom(ed1,"Room A");
		Patient p1 = new Patient(ed1,"Benoit");

		
		try {
			r1.newPatient(p1);
		} catch (FullRoom e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r1.displayPatientsInside();
		
		

	}
	@Test
	public void TestPrintPatientInsideifThereIsNoPatient() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");

		Rooms r1=new WaitingRoom(ed1,"Room A");
		
		r1.displayPatientsInside();

	}
	
	// On test la fonction Remove
	@Test
	public void TestRemovePatientIfThereIsAPatient() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");

		Rooms r1=new WaitingRoom(ed1,"Room A");
		Patient p1 = new Patient(ed1,"Benoit");

		
		try {
			r1.newPatient(p1);
		} catch (FullRoom e) {
			e.printStackTrace();
		}
		r1.displayPatientsInside();
		r1.removePatient(p1);
		r1.displayPatientsInside();
	}
	@Test
	public void TestRemovePatientIfThereIsNoPatient(){
		// No exception is expected here, does nothing in particular
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");

		Rooms r1=new WaitingRoom(ed1,"Room A");
		Rooms r2 = r1;
		Patient p1 = new Patient(ed1,"Benoit");

		
		
		r1.removePatient(p1);
		
		Assert.assertEquals(r1, r2);
		
	}
	

}
