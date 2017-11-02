package fr.ecp.is1220.projet.part1;

public class Nurse implements HumanRessources {
	int id;
	String name;
	String surname;
	NurseState state;
	
	
	/**
	 * Return an int number which is the id of the nurse.
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	/**
	 * Sets a new id for the nurse. Which is the int number taken as parameter.
	 */
	@Override
	public void setId(int id) {
		this.id = id;
		
	}
	/**
	 * Return a string which is the name of the nurse.
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	/**
	 * Sets a new name for the nurse. Which is the string taken as parameter.
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	/**
	 * Return a string which is the surname of the nurse.
	 */
	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return this.surname;
	}
	
	/**
	 * Sets a new surname for the nurse. Which is the string taken as parameter.
	 */
	@Override
	public void setSurname(String surname) {
		// TODO Auto-generated method stub
		this.surname = surname;
	}
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
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.state = NurseState.ONDUTY;
	}
	public Nurse(int id, String name, String surname, int choice) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.setState(choice);
	}
	
	

}
