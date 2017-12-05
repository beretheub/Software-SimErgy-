package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;

public abstract class Rooms implements NonHumanResources {
	protected EmergencyDepartment ed;
	protected int id;
	protected String name;
	protected int capacity;
	protected ArrayList<Patient> listOfPatientsInside;
	/**
	 * Returns the ed of the room
	 */
	public EmergencyDepartment getEd(){
		return ed;
	}
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
	public boolean newPatient(Patient patient) throws FullRoom {
		int numberOfPatient = listOfPatientsInside.size();
		if (this.getCapacity() < 0 || numberOfPatient < this.getCapacity()){
			listOfPatientsInside.add(patient);
			return true; 
		}
		throw new FullRoom();
	}
	/**
	 * Displays the name, surname and id of the patients that are in the room
	 */
	public void displayPatientsInside(){
		System.out.println("Room name : " + this.getName() + ". Id : " + this.getId());
		System.out.println("List of patients inside :");
		if (listOfPatientsInside.size() == 0){
			System.out.println("This room is empty");
			return;
		}
		int i =1;
		for (Patient patient : listOfPatientsInside) {
			System.out.println(i + " - id: " + patient.getId());
			i++;
			
		}
		
	}
	public Rooms(EmergencyDepartment ed, String name) {
		super();
		this.name = name;
		listOfPatientsInside = new ArrayList<>();
		IdGenerator idRoom = IdGenerator.getInstance();
		try {
			this.id = idRoom.generateId(11);
		} catch (WrongIDAttribution e) {
			// n'arrivera jamais
			e.printStackTrace();
		} //Le prefix des id des room est 11
		this.ed = ed;
		ed.addResource(this);
		
	}
	/**
	 * Removes the patient taken in an argument from the room. 
	 * 
	 * If this patient is not in the room, the room is unchanged
	 * 
	 */
	public void removePatient(Patient pat) {
		listOfPatientsInside.remove(pat);
		
	}
	
	
	

}
