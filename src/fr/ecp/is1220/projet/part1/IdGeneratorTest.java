package fr.ecp.is1220.projet.part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IdGeneratorTest {
	

	@Test
	public void WheninstanciationThenNoException() {
		IdGenerator idg1 = IdGenerator.getInstance();	
	}
	@Test
	public void WhenGenerationIdThenIdReturnedAsExpected(){
		IdGenerator idg1 = IdGenerator.getInstance();	
		assertEquals(100, idg1.generateId(10));		
	}
	@Test
	public void WhenMultipleGenerationIdsThenIdsReturnedUniqueAsExpected(){
		IdGenerator idg1 = IdGenerator.getInstance();	
		assertEquals(101, idg1.generateId(10));
		assertEquals(102, idg1.generateId(10));
		assertEquals(113, idg1.generateId(11));
	
	}


}
