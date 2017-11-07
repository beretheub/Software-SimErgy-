package fr.ecp.is1220.projet.part1;

import java.util.ArrayList;

public abstract class Rooms implements NonHumanRessources {
	protected int id;
	protected String name;
	protected int capacity;
	protected ArrayList<Patient> listOfPatientsInside;
	
	/**
	 * returns the capacity (in terms of number of patients) of the room
	 * A negative capacity means that there is no capacity restriction for this room
	 * @return capacity (int) 
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Sets a new capacity (in terms of number of patients) for the room
	 * A negative capacity means that there is no capacity restriction for this room
	 * @param capacity (int)
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return name of the room (String)
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	/**
	 * Sets a new name for the room. 
	 * @param newName (String)
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}
	/**
	 * @return id of the room (int)
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	/**
	 * sets a new id for the room.
	 * @param newId (int)
	 */
	@Override
	public void setId(int newId) {
		// TODO Auto-generated method stub

	}
	/**
	 * Returns the list of patient that are in the room
	 * @return listOfPatientsInside (ArrayList<Patient>)
	 */
	public ArrayList<Patient> getPatientsInside(){
		return listOfPatientsInside;
	}
	/**
	 * Try to add a patient to the room (it can fail if the room is full)
	 * @param patient
	 * @return if the room is full returns false, if there the patient is accepted returns true
	 */
	public boolean newPatient(Patient patient){
		int numberOfPatient = listOfPatientsInside.size();
		if (this.getCapacity() < 0 || numberOfPatient < this.getCapacity()){
			listOfPatientsInside.add(patient);
			return true; 
		}
		return false;
	}
	/**
	 * Displays the name, surname and id of the patients that are in the room
	 */
	public void displayPatientsInside(){
		System.out.println("Room name : " + this.getName() + ". Id : " + this.getId());
		System.out.println("List of patients inside :");
		for (Patient patient : listOfPatientsInside) {
			System.out.println(patient.toString());
			// Attention vérifier que l'on a bien mis en forme patient.toString() !!!
		}
		
	}
	public Rooms( String name) {
		super();
		this.name = name;
		listOfPatientsInside = new ArrayList<>();
		IdGenerator idRoom = IdGenerator.getInstance();
		this.id = idRoom.generateId(01); //Le prefix des id des room est 01 
		
	}
	@Override
	public String toString() {
		return "Rooms [id=" + id + ", name=" + name + ", capacity=" + capacity + ", listOfPatientsInside="
				+ listOfPatientsInside + "]";
	}
	
	

}
