package tests;

import fr.ecp.is1220.projet.part1.Exceptions.ParameterUnifException;
import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Patient;


public class ArrivalTest {
	public static void main(String[] args) throws ParameterUnifException {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		AbstractFactory hrFact = FactoryProducer.getFactory("humanresource");
		HumanResources med1 = hrFact.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
		AbstractFactory hrFact2 = FactoryProducer.getFactory("humanresource");
		HumanResources med2 = hrFact
				2.getHumanResource(ed1, "physician", "Béré", "Heuberger");
		System.out.println(med1.getName());
		
		Patient p1 = new Patient(ed1, "Jo");
		Patient p2= new Patient(ed1, "Ed");
		Patient p3 = new Patient(ed1, "Moe");
		Patient p4 = new Patient(ed1, "Dan");
		
		System.out.println(p1.getName());
		p1.arrives();
		p2.arrives();
		p3.arrives();
		p4.arrives();
		
		
		
		ed1.printPatientInTheEd();
		
		ed1.triagepatients();
		System.out.println(p1.getListOfEvent());
	
		ed1.consultationpatients();
		System.out.println(p1.getListOfEvent());
		
	}

}
