package fr.ecp.is1220.projet.part1.Exceptions;

public class InvalidNameException extends Exception {
	/**
	 * Exception lev�e lorsque le nom entr� n'est pas reconnu 
	 * @return 
	 */
	public InvalidNameException(){
		System.out.println("La ressource demand�e n'existe pas");
	}
}
