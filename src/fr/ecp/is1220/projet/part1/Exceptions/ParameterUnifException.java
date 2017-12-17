package fr.ecp.is1220.projet.part1.Exceptions;

public class ParameterUnifException extends Exception {

	private static final long serialVersionUID = 2822433583719082552L;

	public ParameterUnifException(){
		System.out.println("Les paramètres doivent être positifs !");
	}
}
