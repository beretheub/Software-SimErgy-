package tests;

import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Patient;

public class TriageTest {

	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		AbstractFactory hrFact = FactoryProducer.getFactory("humanresource");
		@SuppressWarnings("unused")
		HumanResources med1 = hrFact.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
		ed1.triagePatients();
		Patient p1 = new Patient(ed1, "Jo");
		Patient p2= new Patient(ed1, "Ed");
		Patient p3 = new Patient(ed1, "Moe");
		Patient p4 = new Patient(ed1, "Dan");
		p1.arrives();
		p2.arrives();
		p3.arrives();
		p4.arrives();
		
		ed1.triagePatients();
		ed1.triagePatients();
		
		ed1.printPatientWaitingforConsultation();
		
		ed1.printPatientInTheEd();
		

	}

}
