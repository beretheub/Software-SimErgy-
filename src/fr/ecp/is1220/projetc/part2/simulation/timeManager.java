package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class timeManager {
	private timeManager instance = null;
	private ArrayList<Event> eventQueue;
	private EnabledEvents enabledEvents;
	
	public timeManager getInstance(){
		if (instance == null){
			return new timeManager();
		}
		else return instance;
	}

	private timeManager() {
		super();
		eventQueue = new ArrayList<>();
		enabledEvents = new EnabledEvents();
	}
	
	public void addEventInEventQueue(Event event){
		this.eventQueue.add(event);
		timeManager.sortEventQueue();
	}

	private static void sortEventQueue() {
		
		
	}
	/**
	 * Begins a simulation for the ED.
	 * Returns a copy of the initial ed entered as a parameter after the simulation
	 * @param Limit, initialED
	 * @return edAfterSimulation
	 */
	public void startSimulation(int Limit, EmergencyDepartment initialED){
		int simTime = 0; // on initialise le temps à 0
		EmergencyDepartment finalED = initialED;  // On crée une copy de l'ed initial, et on retourne son état final, ça permet de pouvoir faire plusieurs simulation sur le même ED en changeant quelques paramètres 
		
	}
	
	

}
