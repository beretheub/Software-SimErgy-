package fr.ecp.is1220.projet.part1;

public class Nurse extends HumanRessources{
	NurseState state;
	/**
	 * Returns the state of the nurse
	 * @return NurseState (Enum)
	 */
	public NurseState getState(){
		return this.state;
	}
	/**
	 * 
	 * @param choice (NurseState Enum)
	 */
	public void setState(NurseState choice){
		this.state = choice;
		
	}
	/**
	 * 3 parameters 
	 * 1. An int number : the id of the nurse
	 * 2. A string : the name of the nurse
	 * 3. A string : the surname of the nurse
	 * 
	 *  A nurse also has a state (OFFDUTY, ONDUTY, OCCUPIED), its state is set ONDUTY by default 
	 *  
	 *  it can also be setted at the declaration, by adding a NurseState Parameter 
	 */
	public Nurse(String name, String surname) {
		super(name, surname);
		this.state = NurseState.ONDUTY;
	}
	public Nurse(String name, String surname, NurseState choice) {
		super(name, surname);
		this.setState(choice);
	}
	
	

}
