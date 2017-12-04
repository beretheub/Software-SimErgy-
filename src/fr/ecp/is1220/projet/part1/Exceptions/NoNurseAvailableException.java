package fr.ecp.is1220.projet.part1.Exceptions;

public class NoNurseAvailableException extends Exception {

	/**
	 * Exception thrown when no nurse is available 
	 */
	public NoNurseAvailableException(){
		System.out.println("No free nurse at time T");
	}
	

}
