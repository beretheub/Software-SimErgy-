package fr.ecp.is1220.projet.part1.Exceptions;

public class noNurseAvailableException extends Exception {

	/**
	 * Exception thrown when no nurse is available 
	 */
	public noNurseAvailableException(){
		System.out.println("No free nurse at time T");
	}
	

}
