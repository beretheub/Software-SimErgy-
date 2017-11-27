package fr.ecp.is1220.projet.part1.Exceptions;

public class noValidOutputException extends Exception {
	/**
	 * Exception levée lorsque le résultat n'est pas valide 
	 */
	public noValidOutputException(){
		System.out.println("The output is not valid");
	}
}
