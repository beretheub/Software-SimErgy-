package fr.ecp.is1220.projet.part1.Exceptions;

public class LOSException extends Exception {
	/**
	 * Exception levée lorsque le temps LOS n'est pas défini 
	 */
	public LOSException(){
		System.out.println("LOS is not defined");
	}
}
