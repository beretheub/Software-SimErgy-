package fr.ecp.is1220.projet.part1.Exceptions;

public class NoPatientWaitingForConsultation extends Exception {

	public NoPatientWaitingForConsultation(){
		System.out.println("No patient is waiting for consultation");
	}
}
