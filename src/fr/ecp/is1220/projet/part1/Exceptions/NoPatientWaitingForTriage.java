package fr.ecp.is1220.projet.part1.Exceptions;


public class NoPatientWaitingForTriage extends Exception {

	private static final long serialVersionUID = -7887724468867874391L;

	public NoPatientWaitingForTriage(){
		System.out.println("No patient is waiting for Triage");
	}
}
