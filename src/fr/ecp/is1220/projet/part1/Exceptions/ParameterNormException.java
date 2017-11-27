package fr.ecp.is1220.projet.part1.Exceptions;

public class ParameterNormException extends Exception {
	public ParameterNormException(){
		System.out.println("L'écat-type doit être positif");
	}
}
