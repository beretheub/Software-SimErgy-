package fr.ecp.is1220.projet.part1;

import org.junit.Test;

public class WaitingRoomTest {
@Test
	private void TestNurse1() {
		// TODO Auto-generated method stub
		Nurse n1=new Nurse("Cathy","Einstein");
		
		n1.setName("Lolita");
		n1.setSurname("arbre");
		
		n1.getName();
		n1.getSurname();
		n1.getId();
		n1.toString();
		
		n1.setState(0);
		n1.toString();
		
		n1.setState(1);
		n1.toString();
		
		n1.setState(2);
		n1.toString();
		
		
		
	}

}
