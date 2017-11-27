
package fr.ecp.is1220.projet.part1.core;

public class Radiography extends HealthServices {

	/**
	 * @param name
	 * @param cost
	 */
	public Radiography(EmergencyDepartment ed, String name) {
		super(ed, name, 15);
		// default price is 15
	}
	public Radiography(EmergencyDepartment ed, String name, float cost) {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.RADIOGRAPHY;
	}

}
