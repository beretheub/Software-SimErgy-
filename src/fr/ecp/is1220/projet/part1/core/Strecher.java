package fr.ecp.is1220.projet.part1.core;

public class Strecher extends Equipment {
	/**
	 * Creates a strecher with a uniq id : 12...
	 * @param name
	 */
	public Strecher(EmergencyDepartment ed, String name) {
		super(ed, name);
	}

	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.STRECHER;
	}
	

}
