package fr.ecp.is1220.projet.part1.Exceptions;


public class NoPatientinED extends Exception {
	public NoPatientinED(){
		System.out.println("This patient is not in this ED");
	}
}
