package fr.ecp.is1220.projet.part1.Exceptions;

public class ParameterExpException extends Exception {
	public ParameterExpException(){
		System.out.println("Le paramètre doit être strictement positif !");
	}
}
