package fr.ecp.is1220.projet.part1;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.ObserverPattern.Observable;
import fr.ecp.is1220.projet.part1.ObserverPattern.Observer;

public abstract class HealthServices implements Observable, NonHumanResources {
	private int id;
	private String name;
	private ArrayList<Observer> observers;
	private ArrayList<Patient> waitingQueue;
	private float cost;
	
	/**
	 * Returns the name of the healthService
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	/**
	 * Sets the name of the healthService
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;

	}
	/**
	 * Returns the id of the healtService 
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void registerObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);

	}

	@Override
	public void deleteObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		// A modifier une fois que l'on aura la structure complète mise en place !
		for (Observer obs : observers) {
			obs.update();
		}
	}
	
	/**
	 * Adds a new patient to the waiting queue
	 * 
	 * @param patient
	 */
	public void newPatient(Patient pat){
		waitingQueue.add(pat);
	}
	
	/**
	 * Returns the list of patients waiting for the health service
	 * @return ArrayList<Patient>
	 */
	public ArrayList<Patient> getQueue(){
		return waitingQueue;
	}
	
	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	/**
	 * Prints a snapshot of the waiting Queue
	 */
	public void printQueue(){
	// Peut être à changer si on passe à une interface graphique ?
		for (Patient patient : waitingQueue) {
			System.out.println("In the line for -- " + this.getName());
			System.out.println(waitingQueue.indexOf(patient) + 1 + " -- name : " + patient.getName() + " -- id : " + patient.getId());
			
		}
		
		
	}

	public HealthServices(String name, float cost) {
		super();
		this.name = name;
		this.cost = cost;
		waitingQueue = new ArrayList<>();
		observers = new ArrayList<>();
		IdGenerator idG = IdGenerator.getInstance();
		id = idG.generateId(13);
	}
}
