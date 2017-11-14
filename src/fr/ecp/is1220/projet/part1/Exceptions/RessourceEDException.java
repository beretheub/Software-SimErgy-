package fr.ecp.is1220.projet.part1.Exceptions;

public class RessourceEDException extends Exception {
	public RessourceEDException(){
		System.out.println("Error, the ressource does not belong to this Emergency Departement");
	}
}
