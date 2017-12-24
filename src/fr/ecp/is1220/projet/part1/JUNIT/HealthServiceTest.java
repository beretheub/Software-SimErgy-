package fr.ecp.is1220.projet.part1.JUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.Exceptions.InvalidNameException;
import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;
import fr.ecp.is1220.projet.part1.FactoryPattern.AbstractFactory;
import fr.ecp.is1220.projet.part1.FactoryPattern.FactoryProducer;
import fr.ecp.is1220.projet.part1.FactoryPattern.HealtServiceFactory;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Insurance;
import fr.ecp.is1220.projet.part1.core.MRIservice;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Physician;
import fr.ecp.is1220.projet.part1.core.ResourcesType;

public class HealthServiceTest {

	@Test
	public void testCreationOfAnHealtService() {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		
		
		MRIservice mri = null;
		mri = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "healthservice");
		
		
		assertEquals(mri.getName(), "MRI 1");
		
	}
	
	@Test
	public void testObserverMethod(){
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		
		HealtServiceFactory fact = (HealtServiceFactory) FactoryProducer.getFactory("healthService");
		
		
		MRIservice mri = null;
		mri = (MRIservice) fact.getHealthService(ed1, "mri", "MRI 1", "healthservice");
		
		
		Physician p1 = new Physician(ed1, "Benoit", "Charmettant");
		Physician p2 = new Physician(ed1, "Jérôme", "Charmettant");
		
		
		Patient pat = null;
		try {
			pat = new Patient(ed1, "Jojo", Insurance.GOLD);
		} catch (WrongIDAttribution e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// La patient n'est ajouté qu'à un des deux physician
		p1.newPatientTreated(pat);
		
		mri.registerObserver(p1);
		mri.registerObserver(p2);
		
		mri.notifyObservers("Le Patient va bien", pat);
		
		// Le message n'apparait que dans une des deux message box (a vérifier sur la console)
		
		p1.printMessageBox();
		p2.printMessageBox();
		
	}

}
