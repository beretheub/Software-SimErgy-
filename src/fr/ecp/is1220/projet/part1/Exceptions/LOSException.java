package fr.ecp.is1220.projet.part1.Exceptions;

public class LOSException extends Exception {

	private static final long serialVersionUID = -4809372525431305740L;

	/**
	 * Exception lev�e lorsque le temps LOS n'est pas d�fini 
	 */
	public LOSException(){
		System.out.println("LOS is not defined");
	}
}
