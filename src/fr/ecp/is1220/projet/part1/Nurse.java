package fr.ecp.is1220.projet.part1;

public class Nurse extends HumanRessources{
	NurseState state;
	/**
	 * Returns the state of the nurse
	 * @return int number :  0 if the nurse is ONDUTY, 1 if the nurse is OFFDUTY, 2 if the nurse is OCCUPIED
	 */
	public int getState(){
		if(this.state == NurseState.OCCUPIED){
			return 2;
		}else if(this.state == NurseState.OFFDUTY){
			return 1;
		}
		return 0;
	}
	/**
	 * 
	 * @param choice
	 * 
	 *  Set the state of the nurse by an int number : 
	 *  
	 *  1 means OFFDUTY
	 *  2 means OCCUPIED 
	 *  0 (or any other number) means ONDUTY
	 */
	public void setState(int choice){
		if (choice == 1){
			this.state = NurseState.OFFDUTY;
		}else if(choice == 2){
			this.state = NurseState.OCCUPIED;
		}else{
			this.state = NurseState.ONDUTY;
		}
		
	}
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
	public Nurse(int id, String name, String surname) {
		super(id, name, surname);
		this.state = NurseState.ONDUTY;
	}
	public Nurse(int id, String name, String surname, int choice) {
		super(id, name, surname);
		this.setState(choice);
	}
	
	

}
