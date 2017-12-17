package fr.ecp.is1220.projet.part1.Exceptions;

public class NoNurseAvailableException extends Exception {

	private static final long serialVersionUID = 8560541547409441612L;

	/**
	 * Exception thrown when no nurse is available 
	 */
	public NoNurseAvailableException(){
		System.out.println("No free nurse at time T");
	}
	

}
