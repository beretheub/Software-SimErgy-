package tests;

import javax.annotation.Resource;

import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.HumanResources;
import fr.ecp.is1220.projet.part1.core.Patient;

public class GeneralTest {
	public static void main(String[] args) {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Grenoble");
		AbstractFactory hrFact = FactoryProducer.getFactory("humanresource");
		HumanResources med1 = hrFact.getHumanResource(ed1, "nurse", "Benoit", "Charmettant");
		System.out.println(med1.toString());
		System.out.println(ed1.toString());
		Patient p1 = new Patient(ed1, "Jo");
		p1.arrives();
		System.out.println(p1.getSeverity());
	
	}
}
