package fr.ecp.is1220.projet.part1.Exceptions;

public class WrongIDAttribution extends Exception {
	/**
	 * Exception lev�e lorsque l'ID attribu� n'est pas valide 
	 */
	public WrongIDAttribution(){
		System.out.println("The ID is not valid ");
	}
}
