package tests;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.Physician;

public class PhysicianTest {
@Test
	public void TestPhysician1() {
		// TODO Auto-generated method stub
		Physician p1=new Physician("Homère","Ortie");
		
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
