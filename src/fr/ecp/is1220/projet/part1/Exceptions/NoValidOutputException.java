package fr.ecp.is1220.projet.part1.Exceptions;

public class NoValidOutputException extends Exception {
	/**
	 * Exception lev�e lorsque le r�sultat n'est pas valide 
	 */
	public NoValidOutputException(){
		System.out.println("The output is not valid");
	}
}
