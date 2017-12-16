package fr.ecp.is1220.projet.part1.core;

public class XrayService extends HealthServices implements java.io.Serializable {
	/**
	 * Creates a new Xray service. It inherits the attributes of a healtService. 
	 * The default price of an Xray is 15, bus you can determine a new price for this specific consultation service
	 */
	
	public XrayService(EmergencyDepartment ed, String name) {
		// Il je fixe le prix par défaut d'un Xray à 15
		super(ed, name, 15, "uniform");
		// TODO Auto-generated constructor stub
		
	}
	public XrayService(EmergencyDepartment ed, String name, float cost, String strat) {
		super(ed, name, cost, strat);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.XRAY;
	}

}
