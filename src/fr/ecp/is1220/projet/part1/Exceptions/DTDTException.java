package fr.ecp.is1220.projet.part1.Exceptions;

public class DTDTException extends Exception {
	
	private static final long serialVersionUID = -8669034974011197597L;

	/**
	 * Exception lev�e lorsque le temps DTDT n'est pas d�fini 
	 */
	public DTDTException(){
		System.out.println("The DTDT is not defined");
	}
}
