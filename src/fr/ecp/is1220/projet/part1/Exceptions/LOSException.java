package fr.ecp.is1220.projet.part1.Exceptions;

public class LOSException extends Exception {
	/**
	 * Exception lev�e lorsque le temps LOS n'est pas d�fini 
	 */
	public LOSException(){
		System.out.println("LOS is not defined");
	}
}
