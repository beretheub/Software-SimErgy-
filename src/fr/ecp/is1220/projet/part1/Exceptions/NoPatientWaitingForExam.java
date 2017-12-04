package fr.ecp.is1220.projet.part1.Exceptions;


public class NoPatientWaitingForExam extends Exception {
	public NoPatientWaitingForExam(){
		System.out.println("No patient is waiting for exam");
	}
}
