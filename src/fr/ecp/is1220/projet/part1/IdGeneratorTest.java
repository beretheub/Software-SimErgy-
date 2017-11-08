package fr.ecp.is1220.projet.part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IdGeneratorTest {
	
	public static void main(String[] args) {
		IdGenerator idg1 = IdGenerator.getInstance();
		int i = idg1.generateId(1);
		System.out.println(i);
		i = idg1.generateId(01);
		System.out.println(i);
		
		
	}
	
/*
	@Test
	public void WheninstanciationThenNoException() {
		IdGenerator idg1 = IdGenerator.getInstance();	
	}
	@Test
	public void WhenGenerationIdThenIdReturnedAsExpected(){
		IdGenerator idg1 = IdGenerator.getInstance();	
		assertEquals(010, idg1.generateId(01));		
	}
	@Test
	public void WhenMultipleGenerationIdsThenIdsReturnedUniqueAsExpected(){
		IdGenerator idg1 = IdGenerator.getInstance();	
		assertEquals(010, idg1.generateId(01));
		assertEquals(011, idg1.generateId(01));
		assertEquals(022, idg1.generateId(02));
	
	}
*/

}
