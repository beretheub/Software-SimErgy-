package fr.ecp.is1220.projet.part1;

import org.junit.Test;

public class HumanRessourcesTest {
@Test
	private void TestHR1() {
		// TODO Auto-generated method stub
		HumanRessources hr1=new HumanRessources("Albert","Einstein");
		
		hr1.setName("Lolita");
		hr1.setSurname("arbre");
		
		hr1.getName();
		hr1.getSurname();
		hr1.getId();
		hr1.toString();
		
		
		
	}

}
