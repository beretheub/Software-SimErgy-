package fr.ecp.is1220.projet.part1.Exceptions;


public class NoPatientWaitingForTriage extends Exception {
	public NoPatientWaitingForTriage(){
		System.out.println("No patient is waiting for Triage");
	}
}
