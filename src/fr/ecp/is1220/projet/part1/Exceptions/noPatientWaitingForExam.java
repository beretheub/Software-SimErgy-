package fr.ecp.is1220.projet.part1.Exceptions;


public class noPatientWaitingForExam extends Exception {
	public noPatientWaitingForExam(){
		System.out.println("No patient is waiting for exam");
	}
}
