package fr.ecp.is1220.projet.part1.Exceptions;


public class NoPatientinED extends Exception {

	private static final long serialVersionUID = -8552732911800940835L;

	public NoPatientinED(){
		System.out.println("This patient is not in this ED");
	}
}
