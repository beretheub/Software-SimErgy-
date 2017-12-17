package fr.ecp.is1220.projet.part1.Exceptions;

public class FullEquipment extends Exception {

	private static final long serialVersionUID = -3897560051942278505L;

	/**
	 * Exception lev�e lorsque l'�quipement n'est pas disponible 
	 */
	public FullEquipment(){
		System.out.println("The equipment is not free");
	}
}
