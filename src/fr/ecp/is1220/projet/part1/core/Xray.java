package fr.ecp.is1220.projet.part1.core;

public class Xray extends HealthServices {
	/**
	 * Creates a new Xray service. It inherits the attributes of a healtService. 
	 * The default price of an Xray is 15, bus you can determine a new price for this specific consultation service
	 */
	
	public Xray(EmergencyDepartment ed, String name) {
		// Il je fixe le prix par défaut d'un Xray à 15
		super(ed, name, 15);
		// TODO Auto-generated constructor stub
		
	}
	public Xray(EmergencyDepartment ed, String name, float cost) {
		super(ed, name, cost);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "xray";
	}

}
