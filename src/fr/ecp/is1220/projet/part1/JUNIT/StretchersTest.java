package fr.ecp.is1220.projet.part1.JUNIT;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.NHRState;
import fr.ecp.is1220.projet.part1.core.Strecher;

public class StretchersTest {

	@Test
	public void CreationTest() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Strecher s1 = new Strecher(ed1,"Strecher 1");
		
		s1.getEd();
		s1.getClass();
		s1.getId();
		s1.getName();
		s1.getNHRState();
		s1.getType();
		
		s1.setName("LOLO");
		s1.setNHRState(NHRState.FREE);
		
		s1.toString();
	}
		@Test
		public void StretcherPatientTest() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Strecher s1 = new Strecher(ed1,"Strecher 1");
		s1.patientLeaving();
		s1.newPatient();
		s1.isFree();
		s1.notify();
		
	}

}
