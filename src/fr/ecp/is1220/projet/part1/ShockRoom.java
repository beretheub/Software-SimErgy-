package fr.ecp.is1220.projet.part1;

public class ShockRoom extends Rooms {
	/**
	 * Create a new shock room with an initial capacity of 1 patient
	 * @param name
	 */
	public ShockRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.setCapacity(1);
		// disons qu'une box room a une capacité de 1.
	}
}
