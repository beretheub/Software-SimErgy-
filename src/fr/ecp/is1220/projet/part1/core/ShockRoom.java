package fr.ecp.is1220.projet.part1.core;

public class ShockRoom extends Rooms implements java.io.Serializable{
	
	private static final long serialVersionUID = 5773377729064464849L;

	/**
	 * Create a new shock room with an initial capacity of 1 patient
	 * @param name
	 */
	public ShockRoom(EmergencyDepartment ed, String name) {
		super(ed, name);
		// TODO Auto-generated constructor stub
		this.setCapacity(1);
		// disons qu'une box room a une capacit� de 1.
	}

	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.SHOCKROOM;
	}

	public boolean isFree() {
		if (listOfPatientsInside.size() > 0){
			return false;
		}
		return true;
	}
}
