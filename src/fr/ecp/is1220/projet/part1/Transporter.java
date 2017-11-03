package fr.ecp.is1220.projet.part1;

public class Transporter extends HumanRessources {
	
	TransporterState state;

	/**
	 * 3 parameters 
	 * 1. An int number : the id of the nurse
	 * 2. A string : the name of the nurse
	 * 3. A string : the surname of the nurse
	 * 
	 *  A nurse also has a state (OFFDUTY, ONDUTY, OCCUPIED), its state is set ONDUTY by default 
	 *  
	 *  it can also be setted at the declaration of the nurse by an int number : 
	 *  1 means OFFDUTY
	 *  2 means OCCUPIED 
	 *  0 (or any other number) means ONDUTY
	 */
	public Transporter(int id, String name, String surname) {
		super(id, name, surname);
		this.state = TransporterState.ONDUTY;
	}
	public Transporter(int id, String name, String surname, int choice) {
		super(id, name, surname);
		this.setState(choice);
	}
	/**
	 * 
	 * @param choice
	 * 
	 *  Set the state of the transporter by an int number : 
	 *  
	 *  1 means OFFDUTY
	 *  2 means OCCUPIED 
	 *  0 (or any other number) means ONDUTY
	 */
	public void setState(int choice){
		if (choice == 1){
			this.state = TransporterState.OFFDUTY;
		}else if(choice == 2){
			this.state = TransporterState.OCCUPIED;
		}else{
			this.state = TransporterState.ONDUTY;
		}
		
	}
	

}
