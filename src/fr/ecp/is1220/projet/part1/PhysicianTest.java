package fr.ecp.is1220.projet.part1;

import org.junit.Test;

public class PhysicianTest {
@Test
	private void TestPhysician1() {
		// TODO Auto-generated method stub
		Physician p1=new Physician("Hom�re","Ortie");
		
		p1.setName("Denis");
		p1.setSurname("Phare");
		
		p1.getName();
		p1.getSurname();
		p1.getId();
		p1.toString();
		
		p1.setState(0);
		p1.toString();
		
		p1.setState(1);
		p1.toString();
		
		p1.setState(2);
		p1.toString();
		
		
		
	}

}
