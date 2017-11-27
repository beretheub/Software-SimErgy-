package fr.ecp.is1220.projet.part1.Exceptions;

public class FullRoom extends Exception {
	/**
	 * Exception levée lorsque la pièce n'est pas disponible 
	 */
	public FullRoom(){
		System.out.println("The room is not free");
	}
}
