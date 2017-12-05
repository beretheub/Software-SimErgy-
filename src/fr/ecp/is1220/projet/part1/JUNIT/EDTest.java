package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;
import fr.ecp.is1220.projet.part1.Exceptions.NoPatientinED;
import fr.ecp.is1220.projet.part1.core.BloodTestService;
import fr.ecp.is1220.projet.part1.core.BoxRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HealthServices;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Resources;
import fr.ecp.is1220.projet.part1.core.ResourcesType;
import fr.ecp.is1220.projet.part1.core.Rooms;
import fr.ecp.is1220.projet.part1.event_v2.Arr_L1;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class EDTest {
	@Test
	public void testEDCHUBlois() {
	 EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
	 Resources n1 = new Nurse (ed1,"nurse 1", "lala");
	 
	 ed1.setEdName("CHU Bracieux");
	 
	 ed1.getClass();
	 ed1.getEdName();
	 ed1.getListOfPatientsWaitingForTriage();
	 ed1.getListOfPatientWaitingForExam();
	 ed1.getListOfPatientWaitingForTransporation();
	 ed1.getOccupiedRoom(ResourcesType.BOXROOM);
	 
	 ed1.returnFreeHumanResource(ResourcesType.NURSE);		
	}

	@Test
	public final void testEDPatients() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Patient p = new Patient (ed1, "Pablo");




		ed1.addPatientInED(p);
		ed1.addPatientWaitingForExam(p);
		ed1.addPatientWaitingForTransportation(p);
		ed1.addPatientWaitingForTriage(p);
		ed1.printPatientInTheEd();
		try {
			ed1.removePatientInTheED(p);
		} catch (NoPatientinED e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ed1.removePatientWaitingForExam(p);
		} catch (NoPatientinED e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ed1.removePatientWaitingForTransportation(p);
		} catch (NoPatientinED e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ed1.removePatientWaitingForTriage(p);
		} catch (NoPatientinED e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@Test
	public final void testEDHR() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Resources n1 = new Nurse (ed1,"nurse 1", "lala");
		ed1.returnFreeHumanResource(ResourcesType.NURSE);
		ed1.addResource(n1);
	}
	@Test
	public final void testEDNHR() {

		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		HealthServices hs = new BloodTestService(ed1,"pelican");
		Rooms r1 = new BoxRoom(ed1,"Room1");
		ed1.returnFreeNonHumanResources(ResourcesType.SHOCKROOM);
		ed1.addResource(r1);
		ed1.addHealthServices(hs);
	}

	@Test
	public final void testEDEvent() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Event e = new Arr_L1(ed1);
		ed1.addEventInEventQueue(e);
		ed1.sortEventQueue(ed1.eventQueue);
	}
}
