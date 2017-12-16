package fr.ecp.is1220.projet.part1.core;
// Ce qui serait bien avec les waiting room serait de savoir dans quel ordre sont arrivés les patients

public class WaitingRoom extends Rooms implements java.io.Serializable {
	/**
	 * Create a new shock room with an initial unlimited capacity
	 * @param name
	 */
	public WaitingRoom(EmergencyDepartment ed, String name) {
		super(ed, name);
		// TODO Auto-generated constructor stub
		this.setCapacity(-1);
		// disons qu'une waiting room a une capacité infinie.
	}

	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.WAITINGROOM;
	}
}
