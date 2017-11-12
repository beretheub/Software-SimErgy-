package fr.ecp.is1220.projet.part1.core;

public class MRI extends HealthServices {
	public MRI(EmergencyDepartment ed, String name){
		// default price is 16
		super(ed, name, 16);
	}
	public MRI(EmergencyDepartment ed, String name, float cost) {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
	}

}
