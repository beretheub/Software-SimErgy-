package fr.ecp.is1220.projet.part1.core;

public class Scan extends HealthServices {
	
	public Scan(EmergencyDepartment ed, String name) {
		super(ed, name, 14);
		// TODO default price of a scan is 14
	}
	public Scan(EmergencyDepartment ed, String name, float cost) {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "scan";
	}

}
