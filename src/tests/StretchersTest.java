package tests;
import fr.ecp.is1220.projet.part1.Strecher;

import static org.junit.Assert.*;

import org.junit.Test;

public class StretchersTest {

	@Test
	public void CreationTest() {
		Strecher strech1 = new Strecher("Strecher 1");
	}
	@Test 
	public void StrecherIdTest(){
		Strecher strech1 = new Strecher("Strecher 1");
		assertEquals(120, strech1.getId());
		
	}

}
