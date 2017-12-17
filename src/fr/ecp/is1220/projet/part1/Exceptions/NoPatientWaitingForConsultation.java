package fr.ecp.is1220.projet.part1.Exceptions;

public class NoPatientWaitingForConsultation extends Exception {

	private static final long serialVersionUID = -1828489587714842335L;

	public NoPatientWaitingForConsultation(){
		System.out.println("No patient is waiting for consultation");
	}
}
