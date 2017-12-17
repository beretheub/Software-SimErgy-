package fr.ecp.is1220.projet.part1.Exceptions;

public class RessourceEDException extends Exception {

	private static final long serialVersionUID = 3971788696424011952L;

	public RessourceEDException(){
		System.out.println("Error, the ressource does not belong to this Emergency Departement");
	}
}
