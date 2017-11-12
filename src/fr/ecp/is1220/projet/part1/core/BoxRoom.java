package fr.ecp.is1220.projet.part1.core;

public class BoxRoom extends Rooms {
	/**
	 * Create a new box room with an initial capacity of 1 patient
	 * @param name
	 */
	public BoxRoom(EmergencyDepartment ed, String name) {
		super(ed, name);
		// TODO Auto-generated constructor stub
		this.setCapacity(1);
		// disons qu'une box room a une capacité de 1.
	}
	
	

}
