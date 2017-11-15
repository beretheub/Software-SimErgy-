package fr.ecp.is1220.projet.part1.Exceptions;

public class noNurseAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Exception thrown when no nurse is available 
	 */
	public noNurseAvailableException(){
		System.out.println("No free nurse at time T");
	}
	

}
