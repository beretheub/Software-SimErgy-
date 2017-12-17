package fr.ecp.is1220.projet.part1.Exceptions;

public class ParameterNormException extends Exception {

	private static final long serialVersionUID = 9133532779984401115L;

	public ParameterNormException(){
		System.out.println("L'écat-type doit être positif");
	}
}
