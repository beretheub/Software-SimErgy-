package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Transporter;
import fr.ecp.is1220.projet.part1.core.TransporterState;

public class TransporterTest {
@Test
	public void TestTransporter1() {
		// TODO Auto-generated method stub
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Transporter t1=new Transporter(ed1,"Rex","Te");
		
		t1.setName("Bull");
		t1.setSurname("Red");
		t1.setState(TransporterState.OCCUPIED);
		
		t1.getName();
		t1.getSurname();
		t1.getId();
		t1.getType();
		t1.getClass();
		t1.getState();
		t1.getEd();
		
		
	}

}
