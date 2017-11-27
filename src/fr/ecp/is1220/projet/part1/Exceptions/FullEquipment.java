package fr.ecp.is1220.projet.part1.Exceptions;

public class FullEquipment extends Exception {
	/**
	 * Exception levée lorsque l'équipement n'est pas disponible 
	 */
	public FullEquipment(){
		System.out.println("The equipment is not free");
	}
}
