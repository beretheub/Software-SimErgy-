package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.NurseState;

/**
 *On teste ici tous les fonctionnalités d'une nurse
 */

public class NurseTest {
@Test
	public void TestNurse1() {
		// TODO Auto-generated method stub
	 	EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Nurse n1=new Nurse(ed1, "Cathy","Einstein");
		Nurse n2=new Nurse(ed1, "Cathy","Einstein", NurseState.OCCUPIED);
		
		n1.setName("Lolita");
		n1.setSurname("arbre");
		n1.setState(NurseState.OCCUPIED);
		
		n1.getName();
		n1.getSurname();
		n1.getId();
		n1.getType();
		n1.getEd();
		
		n1.notify();

		
	}

}
