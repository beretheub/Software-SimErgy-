package fr.ecp.is1220.projet.part1.core;

public class MRIservice extends HealthServices {
	public MRIservice(EmergencyDepartment ed, String name){
		// default price is 16
		super(ed, name, 16);
	}
	public MRIservice(EmergencyDepartment ed, String name, float cost) {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.MRI;
	}

}
