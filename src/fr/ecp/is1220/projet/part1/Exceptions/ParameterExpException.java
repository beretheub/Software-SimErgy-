package fr.ecp.is1220.projet.part1.Exceptions;

public class ParameterExpException extends Exception {

	private static final long serialVersionUID = -4155337639153047634L;

	public ParameterExpException(){
		System.out.println("Le paramètre doit être strictement positif !");
	}
}
