package fr.ecp.is1220.projet.part1.Exceptions;


public class noPatientWaitingForTriage extends Exception {
	public noPatientWaitingForTriage(){
		System.out.println("No patient is waiting for Triage");
	}
}
