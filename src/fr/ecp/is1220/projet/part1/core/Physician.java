package fr.ecp.is1220.projet.part1.core;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.ObserverPattern.Observer;

// TO DO : Compléter la fonction observer une fois que l'autre partie est prête !
// TO DO : Compléter les fonction une fois que la structure de base de l'ensemble est prête

public class Physician extends HumanResources implements Observer {
	
	private PhysicianState state;
	private ArrayList<Patient> patientsBeingOverseen = new ArrayList<>();
	private ArrayList<Patient> patientsTreated = new ArrayList<>();
	private ArrayList<String> messageBox = new ArrayList<>();
	
	
	
	/**
	 * 3 parameters 
	 * 1. An int number : the id of the physician
	 * 2. A string : the name of the physician
	 * 3. A string : the surname of the physician
	 * 
	 *  A physician also has a state (OFFDUTY, ONDUTY, VISITING), its state is set ONDUTY by default 
	 *  
	 *  it can also be setted at the declaration of the physician
	 */
	public Physician(EmergencyDepartment ed, String name, String surname) {
		super(ed, name, surname);
		this.state = PhysicianState.ONDUTY;
	}
	public Physician(EmergencyDepartment ed, String name, String surname, PhysicianState choice) {
		super(ed, name, surname);
		this.setState(choice);
	}
	/**
	 * 
	 * @param choice
	 * 
	 *  Set the state of the physician 
	 */
	public void setState(PhysicianState choice){
		this.state = choice;
		
	}
	/**
	 * Returns the state of the physician
	 */
	public PhysicianState getState(){
		return this.state;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "physician";
	}
	/**
	 * Add a patient to the list of patient that the physician is overseeing
	 * Takes a patient as a parameter
	 */
	void newPatientOverseen(Patient patient){
		patientsBeingOverseen.add(patient);
	}
	/**
	 * Returns a list of patients being overseen by the physician
	 * @return Arraylist<Patient>
	 */
	ArrayList<Patient> getPatientBeingOverseen(){
		return patientsBeingOverseen;
	}
	/**
	 * Add a patient to the list of patient that the physician treated
	 * Takes a patient as a parameter
	 */
	void newPatientTreated(Patient patient){
		patientsTreated.add(patient);
	}
	/**
	 * Returns a list of patients treated by the physician
	 * @return Arraylist<Patient>
	 */
	ArrayList<Patient> getPatientsTreated(){
		return patientsTreated;
	}
	/**
	 * Adds a message to the message box
	 * @param message (String)
	 */
	void newMessage(String message){
		messageBox.add(message);
	}
	/**
	 * Returns an arraylist<String> which is the message box of the physician
	 */
	ArrayList<String> getMessageBox(){
		return messageBox;
		
	}
	/**
	 * Prints the content of the message box of the physician.
	 */
	void printMessageBox(){
		System.out.println("Physician " + this.getName() + " " + this.getSurname() + " (id : " + this.getId() + " )");
		for (int i = 0; i < messageBox.size(); i++) {
			System.out.println("Message " + i + " :\n" + messageBox.get(i));
		}		 
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		// A REMPLIR UN FOIS QUE LE PATTERN OBSERVABLE EST PRET !
		
	}
	
	

	
	
	
	
}
