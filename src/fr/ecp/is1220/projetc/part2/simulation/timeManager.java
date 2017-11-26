package fr.ecp.is1220.projetc.part2.simulation;

import java.util.ArrayList;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.event_v2.Event;

public class timeManager {
	private timeManager instance = null;
	private ArrayList<Event> eventQueue;
	private EnabledEvents enabledEvents;
	public int simTime;
	

	public timeManager() {
		super();
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
	public EmergencyDepartment startSimulation(int limit, EmergencyDepartment initialED){
		// Initialisation de la simulation
		this.simTime = 0; // on initialise le temps � 0
		EmergencyDepartment simultatedED = initialED;  // On cr�e une copy de l'ed initial, et on retourne son �tat final, �a permet de pouvoir faire plusieurs simulation sur le m 
		
		eventQueue = new ArrayList<>(); 	// On initialise les liste en d�but de simulation
		enabledEvents = new EnabledEvents();
		
		// on cr�e la liste enabledEventsbis
		
		EnabledEvents enabledEventsBis = new EnabledEvents();
		
		// initialisation de la liste enabledEventBis
		enabledEventsBis = EnabledEvents.updateEnabledEvents(enabledEvents, simultatedED);
		// initialisation de l'eventQueue 
		EnabledEvents.updateEventQueue(enabledEventsBis, enabledEvents,eventQueue);
		
		while (simTime < limit) {
			Event e1 = eventQueue.get(0);
			eventQueue.remove(0);	
			e1.execute();
			simTime = e1.timeStamp;
			
			enabledEvents = enabledEventsBis;
			
			enabledEvents.removeFirstEventOfType(e1.getType());
			
			enabledEventsBis = EnabledEvents.updateEnabledEvents(enabledEvents, simultatedED);
			
			EnabledEvents.updateEventQueue(enabledEventsBis, enabledEventsBis, eventQueue);	
		}
		
		return simultatedED;
		
		
	}
	
	

}