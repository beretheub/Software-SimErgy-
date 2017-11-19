package fr.ecp.is1220.projet.part1.Exceptions;

public class noPatientWaitingForConsultation extends Exception {

	public noPatientWaitingForConsultation(){
		System.out.println("No patient is waiting for consultation");
	}
}
