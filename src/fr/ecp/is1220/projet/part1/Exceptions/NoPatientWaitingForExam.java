package fr.ecp.is1220.projet.part1.Exceptions;


public class NoPatientWaitingForExam extends Exception {

	private static final long serialVersionUID = 4525690047330009956L;

	public NoPatientWaitingForExam(){
		System.out.println("No patient is waiting for exam");
	}
}
