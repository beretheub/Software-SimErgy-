package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;

public class PhysicianTest {
@Test
	public void TestPhysician1() {
		// TODO Auto-generated method stub
	EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");	
	Physician p1=new Physician(ed1,"Homère","Ortie");
		
		p1.setName("Denis");
		p1.setSurname("Phare");
		p1.setState(PhysicianState.OFFDUTY);
		
		p1.getName();
		p1.getSurname();
		p1.getId();
		p1.getType();
		p1.getClass();
		p1.getEd();
}
		public void TestPhysiciansurPatient() {
					
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");	
		Patient pat=new Patient(ed1, "Alfred");
		Physician p1=new Physician(ed1,"Homère","Ortie");
		
		
		p1.update("anomalie sanguine détectée", pat);
		p1.newPatientTreated(pat);
		p1.prescribeExam(pat, 10);
		
		p1.toString();

		
		
	}

}
