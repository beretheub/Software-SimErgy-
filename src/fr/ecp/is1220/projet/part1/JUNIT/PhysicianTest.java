package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.PhysicianState;

public class PhysicianTest {
	@Test
	public void TestPhysician1() {
		
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
	
	// On test le tri des messages reçus de la part des HealthServices, si le physician suit un patient, le message est
	// inscrit dans la messagebox sinon il ne l'est pas.
	@Test
	public void TestUpdateIfThePAtientDoesNotBelongToThePhisician() {

		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");	
		Patient pat=new Patient(ed1, "Alfred");
		Physician p1=new Physician(ed1,"Homère","Ortie");


		p1.update("anomalie sanguine détectée", pat);
		// Le message ne doit pas apparaitre dans la message boxe
		p1.newPatientTreated(pat);
		p1.prescribeExam(pat, 10);
		
		p1.printMessageBox();
		// C'est ce que l'on observe dans la console 
		

	}
	@Test
	public void  TestUpdateIfThePAtientDoesBelongToThePhisiciant() {

		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");	
		Patient pat=new Patient(ed1, "Alfred");
		Physician p1=new Physician(ed1,"Homère","Ortie");


		
		p1.newPatientTreated(pat); // Le patient est au préalable ajouté à la liste des patients du physician 
		p1.update("anomalie sanguine détectée", pat);
		p1.prescribeExam(pat, 10);
		
		
		
		p1.printMessageBox(); // Ici on observe dans la console 
		

	}
}

