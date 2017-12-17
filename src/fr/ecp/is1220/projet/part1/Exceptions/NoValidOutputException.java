package fr.ecp.is1220.projet.part1.Exceptions;

public class NoValidOutputException extends Exception {

	private static final long serialVersionUID = 5260501273127299197L;

	/**
	 * Exception levée lorsque le résultat n'est pas valide 
	 */
	public NoValidOutputException(){
		System.out.println("The output is not valid");
	}
}
