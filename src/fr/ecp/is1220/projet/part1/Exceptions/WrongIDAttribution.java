package fr.ecp.is1220.projet.part1.Exceptions;

public class WrongIDAttribution extends Exception {
	/**
	 * Exception levée lorsque l'ID attribué n'est pas valide 
	 */
	public WrongIDAttribution(){
		System.out.println("The ID is not valid ");
	}
}
