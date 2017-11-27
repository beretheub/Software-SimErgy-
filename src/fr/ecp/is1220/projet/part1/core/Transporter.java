package fr.ecp.is1220.projet.part1.core;

public class Transporter extends HumanResources {
	
	TransporterState state;

	/**
	 * 3 parameters 
	 * 1. The emergency Department of the transporter
	 * 2. A string : the name of the transporter
	 * 3. A string : the surname of the transporter
	 * 
	 *  A transporter also has a state (OFFDUTY, ONDUTY, OCCUPIED), its state is set ONDUTY by default 
	 *  
	 *  it can also be setted at the declaration of the transporter
	 */
	public Transporter(EmergencyDepartment ed, String name, String surname) {
		super(ed, name, surname);
		this.state = TransporterState.ONDUTY;
	}
	public Transporter(EmergencyDepartment ed, String name, String surname, TransporterState choice) {
		super(ed, name, surname);
		this.setState(choice);
	}
	/**
	 * 
	 * @param onduty
	 * 
	 *  Set the state of the transporter 
	 */
	public void setState(TransporterState state){
		this.state = state;
		
	}
	/**
	 * 
	 * Returns the state of the transporter
	 */
	public TransporterState getState(){
		return this.state;
	}
	@Override
	public ResourcesType getType() {
		// TODO Auto-generated method stub
		return ResourcesType.TRANSPORTER;
	}
	
	

}
