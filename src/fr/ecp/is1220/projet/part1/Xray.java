package fr.ecp.is1220.projet.part1;

public class Xray extends HealthServices {
	/**
	 * Creates a new Xray service. It inherits the attributes of a healtService.
	 * 
	 * The default price of an Xray is 15, bus you can determine a new price for this specific consultation service
	 * 
	 */
	
	public Xray(String name) {
		// Il je fixe le prix par d�faut d'un Xray � 15
		super(name, 15);
		// TODO Auto-generated constructor stub
		
	}
	public Xray(String name, float cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
		
	}

}
