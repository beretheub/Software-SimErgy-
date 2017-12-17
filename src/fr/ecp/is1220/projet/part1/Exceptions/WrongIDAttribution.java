package fr.ecp.is1220.projet.part1.Exceptions;

public class WrongIDAttribution extends Exception {

	private static final long serialVersionUID = -2238276915652561456L;

	/**
	 * Exception levée lorsque l'ID attribué n'est pas valide 
	 */
	public WrongIDAttribution(){
		System.out.println("The ID is not valid ");
	}
}
