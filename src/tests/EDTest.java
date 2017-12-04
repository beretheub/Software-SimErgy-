package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Insurance;
import fr.ecp.is1220.projet.part1.core.Nurse;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.Resources;
import fr.ecp.is1220.projet.part1.core.ResourcesType;

public class EDTest {
	@Test
	public void testEDCHUBlois() {
 EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
 EmergencyDepartment ed2 = new EmergencyDepartment("CHU Bracieux");
 Resources n1 = new Nurse (ed1,"nurse 1", "lala");
 ed1.setEdName("CHU Bracieux");
 //assertEquals(ed1,ed2);
 
 ed1.returnFreeHumanResource(ResourcesType.NURSE);
 
		
}
	
	
}
