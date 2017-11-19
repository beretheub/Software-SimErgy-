package fr.ecp.is1220.projet.part1.Exceptions;


public class noPatientinED extends Exception {
	public noPatientinED(){
		System.out.println("This patient is not in this ED");
	}
}
