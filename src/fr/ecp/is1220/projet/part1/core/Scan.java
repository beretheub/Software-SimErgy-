package fr.ecp.is1220.projet.part1.core;

public class Scan extends HealthServices implements java.io.Serializable {
	
	public Scan(EmergencyDepartment ed, String name) {
		super(ed, name, 14, "uniform");
		// TODO default price of a scan is 14
	}
	public Scan(EmergencyDepartment ed, String name, float cost, String choice) {
		super(ed, name, cost, choice);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.SCAN;
	}

}
