package fr.ecp.is1220.projet.part1;
// Ce qui serait bien avec les waiting room serait de savoir dans quel ordre sont arrivés les patients
public class WaitingRoom extends Rooms {
	/**
	 * Create a new shock room with an initial unlimited capacity
	 * @param name
	 */
	public WaitingRoom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.setCapacity(-1);
		// disons qu'une box room a une capacité infinie.
	}
}
