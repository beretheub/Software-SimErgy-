package fr.ecp.is1220.projet.part1.Exceptions;

public class WrongIDAttribution extends Exception {

	private static final long serialVersionUID = -2238276915652561456L;

	/**
	 * Exception lev�e lorsque l'ID attribu� n'est pas valide 
	 */
	public WrongIDAttribution(){
		System.out.println("The ID is not valid ");
	}
}
